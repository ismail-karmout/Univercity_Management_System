import { Component, OnInit, ElementRef } from '@angular/core';
import { Filiere } from '../../../models/filiere.module';
import { FilieresService } from '../../../services/filieres.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-filiere',
  templateUrl: './filiere.component.html',
  styleUrl: './filiere.component.css'
})
export class FiliereComponent implements OnInit {
  
  filieres: Filiere[] = [];
  filiereForm: FormGroup;

  constructor(
    private filiereService: FilieresService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.filiereForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
    this.loadFiliere(); 
  }

  loadFiliere(): void {
    this.filiereService.getAllFilieres().subscribe(data => {
      this.filieres = data;
    });
  }

  deleteFiliere(filiereId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this filiere!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Call the service to delete AnneeUniversitaire
        this.filiereService.deleteFiliere(filiereId).subscribe({
          next: () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your filiere has been deleted.',
              'success'
            );
            // Remove the deleted AnneeUniversitaire from the list
            this.filieres = this.filieres.filter(filiere => filiere.id !== filiereId);
          },
          error: (error) => {
            console.error('Error deleting filiere:', error);
            // If an error occurs during deletion, show an error message with SweetAlert
            Swal.fire(
              'Error!',
              'An error occurred while deleting the filiere',
              'error'
            );
          }
        });
      }
    });
  }
  
 

  editFiliere(filiereId: number): void {
    console.log('FiliereID:', filiereId);

    if (filiereId) {
      this.router.navigate(['/filiere/edit', filiereId]);
    }
  }
}
