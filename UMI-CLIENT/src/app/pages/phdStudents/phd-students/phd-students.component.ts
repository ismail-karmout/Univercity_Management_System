import { Component } from '@angular/core';
import { PhdStudent } from '../../../models/phdStudent.model';
import { PhdStudentService } from '../../../services/phdStudent.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-phd-students',
  templateUrl: './phd-students.component.html',
  styleUrl: './phd-students.component.css'
})
export class PhdStudentsComponent {
  phdStudents!: PhdStudent[];

  constructor(
    private phdStudentService: PhdStudentService,
    private router: Router
  ){}

  ngOnInit(): void{
    this.getAllPhdStudents();
  }

  getAllPhdStudents(): void{
    this.phdStudentService.getAllPhdStudents().subscribe(
      data => this.phdStudents = data
    );
  }

  handleDeletePhdStudent(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this module!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.phdStudentService.deletePhdStudent(id).subscribe({
          next: (data) => {
            Swal.fire(
              'Deleted!',
              'Your module has been deleted.',
              'success'
            );
            // Refresh the modules list after deletion
                    this.ngOnInit();

          },
          error: (err) => {
            Swal.fire(
              'Error!',
              'An error occurred while deleting the module.',
              'error'
            );
          }
        });
      }
    });
  }

  handleEditPhdStudent(phdStudent: PhdStudent){
    this.router.navigateByUrl("phdStudents/edit/"+phdStudent.id);
  }
}
