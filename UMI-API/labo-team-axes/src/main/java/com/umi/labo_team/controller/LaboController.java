package com.umi.labo_team.controller;

import com.umi.labo_team.dto.LaboDto;
import com.umi.labo_team.feign.DepartmentServiceClient;
import com.umi.labo_team.feign.EcoleDoctoraleServiceClient;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.model.EcoleDoctorale;
import com.umi.labo_team.service.LaboService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/labos")

public class LaboController {
    private final LaboService laboService;
    private DepartmentServiceClient departmentServiceClient;
    private EcoleDoctoraleServiceClient ecoleDoctoraleServiceClient;


    // Build add labo Rest api
    @PostMapping
    public ResponseEntity<LaboDto> createLabo(@RequestBody LaboDto laboDto) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        laboDto.setCreated_at(currentDateTime);
        laboDto.setUpdated_at(currentDateTime);
        System.out.println("============================");
        System.out.println(laboDto.getEcole_doctorale_id());
        try {
            LaboDto savedLabo = laboService.createLabo(laboDto);
            return new ResponseEntity<>(savedLabo, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // Handle the case where the department_id constraint is violated
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("{laboId}/assign-department/{departmentId}")
    ResponseEntity<String> assignLaboToDepartment(
            @PathVariable("laboId") Long laboId,
            @PathVariable("departmentId") Long departmentId)
    {
        laboService.assignLaboToDepartment(laboId, departmentId);
        return ResponseEntity.ok("Department assigned successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<LaboDto> getLaboById(@PathVariable("id") Long laboId){
        LaboDto laboDto = laboService.getLaboById(laboId);
        Department department=departmentServiceClient.getDepartmentById(laboDto.getDepartment_id());
        EcoleDoctorale ecoleDoctorale=ecoleDoctoraleServiceClient.getEcoleDoctoraleById(laboDto.getEcole_doctorale_id());

        laboDto.setDepartment(department);
        laboDto.setEcoleDoctorale(ecoleDoctorale);
        return ResponseEntity.ok(laboDto);
    }

    @GetMapping
    public ResponseEntity<List<LaboDto>> getAllLabos(){
        List<LaboDto> labos =  laboService.getAllLabos();
//        labos.forEach(labo->{
//            labo.setDepartment(departmentServiceClient.getDepartmentById(labo.getDepartment_id()));
//            labo.setEcoleDoctorale(ecoleDoctoraleServiceClient.getEcoleDoctoraleById(labo.getEchole_doctorale_id()));
//        });
        return ResponseEntity.ok(labos);
    }

    @PutMapping("{id}")
    public ResponseEntity<LaboDto> updateLabo(@PathVariable("id") Long laboId, @RequestBody LaboDto laboDto){
        LaboDto laboDto1 = laboService.updateLabo(laboId, laboDto);
        return ResponseEntity.ok(laboDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLabo(@PathVariable("id") Long laboId){
        laboService.deleteLabo(laboId);
//        return ResponseEntity.ok("Labo has deleted successfully");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = laboService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = laboService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}