import { Component, OnInit, ElementRef } from '@angular/core';
import { Publication } from '../../../models/publication.model';
import { PublicationService } from '../../../services/publication.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrl: './publication.component.css'
})
export class PublicationComponent  implements OnInit {
  
  publications: Publication[] = [];
  publicationForm: FormGroup;

  constructor(
    private publicationService: PublicationService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.publicationForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      
    });
  }

  ngOnInit(): void {
    this.loadPublication(); 
  }

  loadPublication (): void {
    this.publicationService.getAllPublications().subscribe(data => {
      this.publications = data;
    });
  }

  deletePublication(publicationId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this publication!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Call the service to delete 
        this.publicationService.deletePublication(publicationId).subscribe({
          next: () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your publication has been deleted.',
              'success'
            );
            // Remove the deleted   from the list
            this.publications = this.publications.filter(publication => publication.id !== publicationId);
          },
          error: (error) => {
            console.error('Error deleting publication:', error);
            // If an error occurs during deletion, show an error message with SweetAlert
            Swal.fire(
              'Error!',
              'An error occurred while deleting the publication',
              'error'
            );
          }
        });
      }
    });
  }
  
 

  editPublication(publicationId: number): void {
    console.log('PublicationID:', publicationId);

    if (publicationId) {
      this.router.navigate(['/publication/edit', publicationId]);
    }
  }
}

