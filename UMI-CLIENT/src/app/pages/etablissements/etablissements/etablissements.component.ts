// etablissements.component.ts
import { Component, OnInit } from '@angular/core';
import { EtablissementService } from '../../../services/etablissement.service';
import { Etablissement } from '../../../models/etablissement.module';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-etablissements',
  templateUrl: './etablissements.component.html',
  styleUrls: ['./etablissements.component.css']
})
export class EtablissementsComponent implements OnInit {
  etablissements: Etablissement[] = [];
  etablissementForm: FormGroup;

  constructor(
    private etablissementService: EtablissementService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.etablissementForm = this.formBuilder.group({
      // Define your form controls here based on your Etablissement model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadEtablissements();
  }

  loadEtablissements(): void {
    this.etablissementService.getAllEtablissements().subscribe(data => {
      this.etablissements = data;
    });
  }


  deleteEtablissement(etablissementId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this etablissement!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the etablissemtnService to delete the etablissement
        this.etablissementService.deleteEtablissement(etablissementId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your etablissement has been deleted.',
              'success'
            );
            // Refresh the local list of etablissements after deletion
            this.etablissements = this.etablissements.filter(etablissement => etablissement.id !== etablissementId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting etablissement:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the etablissement.',
              'error'
            );
          }
        );
      }
    });
  }

  editEtablissement(etablissementId: number): void {
    console.log('Etablissement ID:', etablissementId);

    if (etablissementId) {
      this.router.navigate(['/etablissements/edit', etablissementId]);
    }
  }

}
