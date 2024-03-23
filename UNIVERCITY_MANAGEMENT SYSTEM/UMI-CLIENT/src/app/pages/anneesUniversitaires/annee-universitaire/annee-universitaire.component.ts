import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-annee-universitaire',
  templateUrl: './annee-universitaire.component.html',
  styleUrl: './annee-universitaire.component.css'
})
export class AnneeUniversitaireComponent implements OnInit {
  
  anneeUniversitaires: AnneeUniversitaire[] = [];
  anneeUniversitaireForm: FormGroup;

  constructor(
    private anneeUniversitaireService: AnneeUniversitaireService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.anneeUniversitaireForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
    this.loadAnneeUniversitaire(); 
  }

  loadAnneeUniversitaire(): void {
    this.anneeUniversitaireService.getAllAnneesUniversitaires().subscribe(data => {
      this.anneeUniversitaires = data;
    });
  }

  deleteAnneeUniversitaire(anneeUniversitaireId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this academic year!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Call the service to delete AnneeUniversitaire
        this.anneeUniversitaireService.deleteAnneeUniversitaire(anneeUniversitaireId).subscribe({
          next: () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your academic year has been deleted.',
              'success'
            );
            // Remove the deleted AnneeUniversitaire from the list
            this.anneeUniversitaires = this.anneeUniversitaires.filter(anneeUniversitaire => anneeUniversitaire.id !== anneeUniversitaireId);
          },
          error: (error) => {
            console.error('Error deleting academic year:', error);
            // If an error occurs during deletion, show an error message with SweetAlert
            Swal.fire(
              'Error!',
              'An error occurred while deleting the academic year',
              'error'
            );
          }
        });
      }
    });
  }
  
 

  editAnneeUniversitaire(anneeUniversitaireId: number): void {
    console.log('AnneeUniversitaire ID:', anneeUniversitaireId);

    if (anneeUniversitaireId) {
      this.router.navigate(['/annee-universitaire/edit', anneeUniversitaireId]);
    }
  }
}
