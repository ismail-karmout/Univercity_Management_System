package com.umi.departmentetablissement.department.controller;

import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.dto.EtablissementDto;
import com.umi.departmentetablissement.department.entity.Department;
import com.umi.departmentetablissement.department.entity.Etablissement;
import com.umi.departmentetablissement.department.mapper.EtablissementMapper;
import com.umi.departmentetablissement.department.service.DepartmentService;
import com.umi.departmentetablissement.department.service.EtablissementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    private DepartmentService departmentService;
    private EtablissementService etablissementService;

    // Build add department Rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentDto.setCreated_at(LocalDateTime.now());
        departmentDto.setUpdated_at(LocalDateTime.now());
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
      List<DepartmentDto> departments =  departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.updateDepartment(departmentId, departmentDto);
        return ResponseEntity.ok(departmentDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.noContent().build();
//        return ResponseEntity.ok("Department has deleted successfully");
    }


}