package com.umi.planingexamservice.services.impl;

import com.umi.planingexamservice.dtos.PlaningExamDto;
import com.umi.planingexamservice.entities.PlaningExam;
import com.umi.planingexamservice.exceptions.ResourceNotFoundException;
import com.umi.planingexamservice.feign.SemestreServiceClient;
import com.umi.planingexamservice.mappers.PlaningExamMapper;
import com.umi.planingexamservice.model.Semestre;
import com.umi.planingexamservice.repositories.PlaningExamRepository;
import com.umi.planingexamservice.services.PlaningExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaningExamServiceImpl implements PlaningExamService {
    private PlaningExamRepository planingExamRepository;
    private SemestreServiceClient semestreServiceClient;
    @Override
    public PlaningExamDto createPlaningExam(PlaningExamDto planingExamDto) {
        PlaningExam planingExam = PlaningExamMapper.mapToPlaningExam(planingExamDto);
        PlaningExam savedPlaningExam = planingExamRepository.save(planingExam);
        return PlaningExamMapper.mapToPlaningExamDto(savedPlaningExam);
    }

    @Override
    public PlaningExamDto getPlaningExamById(Long planingExamId) {
        PlaningExam planingExam = planingExamRepository.findById(planingExamId)
                .orElseThrow(()-> new ResourceNotFoundException("Planing exam is not exists with given id " +planingExamId));
        if(planingExam.getSemestreId()!= null){
            planingExam.setSemestre(semestreServiceClient.getSemestreById(planingExam.getSemestreId()));
        }
        return PlaningExamMapper.mapToPlaningExamDto(planingExam);
    }

    @Override
    public List<PlaningExamDto> getAllPlaningExam() {
        List<PlaningExam> planingExams = planingExamRepository.findAll();

        planingExams.forEach( planingExam -> {
            if(planingExam.getSemestreId() != null){
                Semestre semestre =  semestreServiceClient.getSemestreById(planingExam.getSemestreId());
                planingExam.setSemestre(semestre);
            }
        });

        return planingExams.stream().map((planing)->PlaningExamMapper.mapToPlaningExamDto(planing))
                .collect(Collectors.toList());
    }

    @Override
    public PlaningExamDto updatePlaningExam(Long planingExamId, PlaningExamDto updatedPlaningExam) {
        PlaningExam planingExam = planingExamRepository.findById(planingExamId)
                .orElseThrow(()-> new ResourceNotFoundException("Planing exam is not exists with given id " +planingExamId));
        if(updatedPlaningExam.getAvis()!= null) planingExam.setAvis(updatedPlaningExam.getAvis());
        if(updatedPlaningExam.getPlaning()!= null) planingExam.setPlaning(updatedPlaningExam.getPlaning());
        if(updatedPlaningExam.getExam()!= null) planingExam.setExams(updatedPlaningExam.getExam());

        PlaningExam planingExamUpdatedObj = planingExamRepository.save(planingExam);

        return PlaningExamMapper.mapToPlaningExamDto(planingExamUpdatedObj);
    }

    @Override
    public void deletePlaningExam(Long planingExamId) {
        PlaningExam planingExam = planingExamRepository.findById(planingExamId)
                .orElseThrow(()-> new ResourceNotFoundException("Planing exam is not exists with given id " +planingExamId));
        planingExamRepository.deleteById(planingExamId);
    }

    @Override
    public void saveFile(MultipartFile file) throws IOException {
//        if (file.isEmpty()) {
//            throw new IllegalArgumentException("File is empty");
//        }
//
//        // Generate a unique file name
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//
//        // Specify the directory where the file will be stored
//        Path uploadDir = Paths.get("uploads");
//        if (!Files.exists(uploadDir)) {
//            Files.createDirectories(uploadDir);
//        }
//
//        // Save the file to the specified directory
//        Path filePath = uploadDir.resolve(fileName);
//        Files.copy(file.getInputStream(), filePath);
//
//        // Set the file data in the PlaningExam entity and save it to the database
//        PlaningExam planingExam = new PlaningExam();
//        planingExam.setFileData(Files.readAllBytes(filePath));
//        planingExamRepository.save(planingExam);
    }
}
