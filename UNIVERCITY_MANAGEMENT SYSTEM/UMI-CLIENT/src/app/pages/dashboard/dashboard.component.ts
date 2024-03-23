import { Component } from '@angular/core';
import { Etablissement } from '../../models/etablissement.module';
import { Router } from '@angular/router';
import { EtablissementService } from '../../services/etablissement.service';
import { Department } from '../../models/department.module';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DepartmentService } from '../../services/department.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})

export class DashboardComponent {
  departments: Department[] = [];
  departmentForm: FormGroup;

  constructor(
    private departmentService: DepartmentService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.departmentForm = this.formBuilder.group({
      // Define your form controls here based on your Department model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadDepartments();
  }

  loadDepartments(): void {
    this.departmentService.getAllDepartments().subscribe(data => {
      this.departments = data;
    });
  }

  deleteDepartment(DepartmentId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this department!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the departmentService to delete the department
        this.departmentService.deleteDepartment(DepartmentId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your department has been deleted.',
              'success'
            );
            // Refresh the local list of departments after deletion
            this.departments = this.departments.filter(department => department.id !== DepartmentId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting department:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the department.',
              'error'
            );
          }
        );
      }
    });
  }

  // handleAddModule(){
  //   let module = this.moduleFormGroup.value;
  //   this.moduleService.saveModule(module).subscribe({
  //     next : data => {
  //       Swal.fire({
  //         position: 'center',
  //         icon: 'success',
  //         title: 'Your work has been saved',
  //         showConfirmButton: false,
  //         timer: 1500
  //       })
  //       this.moduleFormGroup.reset()
  //     },
  //     error : err => {
  //       console.log(err);
  //     }
  //     })
  //   }

  // deleteDepartment(DepartmentId: number): void {
  //   const confirmDelete = confirm('Are you sure you want to delete this Department?');
  //   if (confirmDelete) {
  //     this.departmentService.deleteDepartment(DepartmentId);
  //     this.departments = this.departments.filter(etab => etab.id !== DepartmentId);

  //     // console.log('Department deleted successfully');
  //     // (
  //     //   () => {
  //     //     // Remove the deleted item from the local list

  //     //     // Optionally, you can display a success message to the user or perform additional actions
  //     //   },
  //     //   (error) => {
  //     //     this.Departments = this.Departments.filter(etab => etab.id !== DepartmentId);

  //     //     console.error('Error deleting Department:', error);
  //     //     // Optionally, you can display an error message to the user or perform additional actions
  //     //   }
  //     // );
  //   }
  // }

  editDepartment(DepartmentId: number): void {
    console.log('Department ID:', DepartmentId);

    if (DepartmentId) {
      this.router.navigate(['/departments/edit', DepartmentId]);
    }
  }

  // createDepartment(): void {
  //   if (this.DepartmentForm.valid) {
  //     const newDepartment: Department = this.DepartmentForm.value;
  //     this.DepartmentService.createDepartment(newDepartment).subscribe(() => {
  //       this.loadDepartments();
  //       this.DepartmentForm.reset();
  //     });
  //   }
  // }

  // updateDepartment(id: number): void {
  //   if (this.DepartmentForm.valid) {
  //     const updatedDepartment: Department = this.DepartmentForm.value;
  //     this.DepartmentService.updateDepartment(id, updatedDepartment).subscribe(() => {
  //       this.loadDepartments();
  //       this.DepartmentForm.reset();
  //     });
  //   }
  // }

  // deleteDepartment(id: number): void {
  //   this.DepartmentService.deleteDepartment(id).subscribe(() => {
  //     this.loadDepartments();
  //   });
  // }
}
