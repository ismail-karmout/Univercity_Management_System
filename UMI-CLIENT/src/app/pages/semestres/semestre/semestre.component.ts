import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Semestre } from '../../../models/semestre.module';
import { SemestresService } from '../../../services/semestres.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-semestre',
  templateUrl: './semestre.component.html',
  styleUrl: './semestre.component.css'
})
export class SemestreComponent implements OnInit {
  
  semestres: Semestre[] = [];
  semestreForm: FormGroup;

  constructor(
    private semestreService: SemestresService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.semestreForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
    this.loadSemestre(); 
  }

  loadSemestre(): void {
    this.semestreService.getAllSemestres().subscribe(data => {
      this.semestres = data;
    });
  }

  deleteSemestre(semestreId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this semester!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Call the service to delete AnneeUniversitaire
        this.semestreService.deleteSemestre(semestreId).subscribe({
          next: () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Yoursemester has been deleted.',
              'success'
            );
            // Remove the deleted AnneeUniversitaire from the list
            this.semestres = this.semestres.filter(semestre => semestre.id !== semestreId);
          },
          error: (error) => {
            console.error('Error deleting semester:', error);
            // If an error occurs during deletion, show an error message with SweetAlert
            Swal.fire(
              'Error!',
              'An error occurred while deleting the semester',
              'error'
            );
          }
        });
      }
    });
  }
  
 

  editSemestre(semestreId: number): void {
    console.log('Semestre ID:', semestreId);

    if (semestreId) {
      this.router.navigate(['/semestre/edit', semestreId]);
    }
  }
}
