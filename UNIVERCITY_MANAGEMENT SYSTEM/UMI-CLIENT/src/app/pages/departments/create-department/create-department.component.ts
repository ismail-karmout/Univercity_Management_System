import { Component, OnInit } from '@angular/core';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
import { EtablissementService } from '../../../services/etablissement.service';
import { Etablissement } from '../../../models/etablissement.module';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-department',
    templateUrl: './create-department.component.html',
    styleUrls: ['./create-department.component.css']
})
export class CreateDepartmentComponent implements OnInit {

    departments: Department[] = [];
    etablissements: Etablissement[] = [];
    newDepartment: Department = { name: '', description: '', slug: '', etablissement: { id: 0, name: '', slug: '', description: '' } };

    constructor(
        private departmentService: DepartmentService,
        private etablissementService: EtablissementService,
        private router: Router
    ) { }

    ngOnInit(): void {
        // this.loadDepartments();
        this.loadEtablissements();
    }

    loadDepartments(): void {
        this.departmentService.getAllDepartments().subscribe(Departments => {
            this.departments = Departments;
        });
    }

    createDepartment(): void {
        this.departmentService.createDepartment(this.newDepartment).subscribe(() => {
            this.loadDepartments();
            this.newDepartment = { name: '', description: '', slug: '', etablissement: { id: 0, name: '', slug: '', description: '' } };
            Swal.fire(
                'Create!',
                'Your department has been created successefully.',
                'success'
            );
            this.router.navigate(['/departments']); // Adjust the route based on your actual route configuration
        });
    }
    loadEtablissements(): void {
        this.etablissementService.getAllEtablissements().subscribe(data => {
            this.etablissements = data;
        });
    }

    updateDepartment(id: number, Department: Department): void {
        this.departmentService.updateDepartment(id, Department).subscribe(() => {
            this.loadDepartments();
        });
    }

    deleteDepartment(id: number): void {
        this.departmentService.deleteDepartment(id).subscribe(() => {
            this.loadDepartments();
        });
    }
}
