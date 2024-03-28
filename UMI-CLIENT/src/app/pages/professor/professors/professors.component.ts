import { Component } from '@angular/core';
import { Professor } from '../../../models/professor.model';
import { ProfessorService } from '../../../services/professor.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-professors',
  templateUrl: './professors.component.html',
  styleUrl: './professors.component.css'
})
export class ProfessorsComponent {
  professors!: Professor[];

  constructor(
    private professorService: ProfessorService,
    private router: Router
  ){}

  ngOnInit(): void{
    this.getAllProfessors();
  }

  getAllProfessors(): void{
    this.professorService.getAllProfessors().subscribe(
      data => this.professors = data
    );
  }

  handleDeleteProfessor(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this module!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.professorService.deleteProfessor(id).subscribe({
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

  handleEditProfessor(professor: Professor){
    this.router.navigateByUrl("professors/edit/"+professor.id);
  }

}
