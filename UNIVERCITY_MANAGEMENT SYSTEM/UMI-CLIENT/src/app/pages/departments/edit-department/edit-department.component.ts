import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
import { Etablissement } from '../../../models/etablissement.module';
import { EtablissementService } from '../../../services/etablissement.service';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-department-edit',
    templateUrl: './edit-department.component.html',
    styleUrls: ['./edit-department.component.css']
})
export class EditDepartmentComponent implements OnInit {
    selectedDepartment: Department = { id: 0, name: '', description: '', slug: '', etablissement: { id: 0, name: '', slug: '', description: '' }};
    etablissements: Etablissement[] = [];

    constructor(
        private DepartmentService: DepartmentService,
        private route: ActivatedRoute,
        private router: Router,
        private etablissementService: EtablissementService
    ) { }

    ngOnInit(): void {
        // Fetch the Department ID from the route parameters
        const DepartmentId = this.route.snapshot.params['id'];

        // Call the service to get the selected Department
        this.DepartmentService.getDepartmentById(DepartmentId).subscribe(
            (Department: Department) => {
                this.selectedDepartment = Department;
            },
            (error) => {
                console.error('Error fetching Department:', error);
            }
        );
        this.loadEtablissements();
    }

    loadEtablissements(): void {
        this.etablissementService.getAllEtablissements().subscribe(data => {
            this.etablissements = data;
        });
    }
    updateDepartment(): void {
        // Call the service to update the Department
        this.DepartmentService.updateDepartment(this.selectedDepartment.id!, this.selectedDepartment).subscribe(
            () => {
                Swal.fire(
                    'Udpate!',
                    'Your department has been updated successefully.',
                    'success'
                );
                // Redirect to the Departments list or navigate to the desired page
                this.router.navigate(['/departments']);
            },
            (error) => {
                console.error('Error updating department:', error);
            }
        );
    }
}
