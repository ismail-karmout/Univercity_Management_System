import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Formation} from '../../../models/formation.module';
import { FormationService } from '../../../services/formation.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrl: './formation.component.css'
})
export class FormationComponent implements OnInit {
  
  formations: Formation[] = [];
  formationForm: FormGroup;

  constructor(
    private formationService: FormationService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.formationForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
    this.loadFormation(); 
  }

  loadFormation(): void {
    this.formationService.getAllFormations().subscribe(data => {
      this.formations = data;
    });
  }

  deleteFormation(formationId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this formation!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Call the service to delete AnneeUniversitaire
        this.formationService.deleteFormation(formationId).subscribe({
          next: () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your formation has been deleted.',
              'success'
            );
            // Remove the deleted AnneeUniversitaire from the list
            this.formations = this.formations.filter(formation => formation.id !== formationId);
          },
          error: (error) => {
            console.error('Error deleting formation:', error);
            // If an error occurs during deletion, show an error message with SweetAlert
            Swal.fire(
              'Error!',
              'An error occurred while deleting the formation',
              'error'
            );
          }
        });
      }
    });
  }
  
 

  editFormation(formationId: number): void {
    console.log('Formation ID:', formationId);

    if (formationId) {
      this.router.navigate(['/formation/edit', formationId]);
    }
  }

  // Method to convert ArrayBuffer to base64 string for image display
  getBase64Image(imageBuffer: ArrayBuffer): string {
    if (imageBuffer) {
      const bytes = new Uint8Array(imageBuffer);
      let binary = '';
      for (let i = 0; i < bytes.length; i++) {
        binary += String.fromCharCode(bytes[i]);
      }
      return 'data:image/png;base64,' + window.btoa(binary);
    }
    return ''; // Return empty string if no image buffer
  }

  // Method to open document in new tab
  openDocument(documentPath: string): void {
    if (documentPath) {
      window.open(documentPath, '_blank');
    }
  }
}
