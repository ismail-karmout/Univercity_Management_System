import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-annee-universitaire',
  templateUrl: './edit-annee-universitaire.component.html',
  styleUrl: './edit-annee-universitaire.component.css'
})
export class EditAnneeUniversitaireComponent implements OnInit {

    selectedAnneeUniversitaire: AnneeUniversitaire = { id: 0, courante: '', startYear: '' , endYear: ''};

    constructor(
        private AnneeUniversitaireService: AnneeUniversitaireService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit(): void {
        // Fetch the ID from the route parameters
        const anneeUniversitaireId = this.route.snapshot.params['id'];
      
        // Call the service to get the selected AnneeUniversitaire
        this.AnneeUniversitaireService.getAnneeUniversitaireById(anneeUniversitaireId).subscribe({
          next: (anneeUniversitaire: AnneeUniversitaire) => {
            this.selectedAnneeUniversitaire = anneeUniversitaire;
          },
          error: (error) => {
            console.error('Error fetching AnneeUniversitaire:', error);
          }
        });
      }
      
      updateAnneeUniversitaire(): void {
        // Call the service to update AnneeUniversitaire
        this.AnneeUniversitaireService.updateAnneeUniversitaire(this.selectedAnneeUniversitaire.id!, this.selectedAnneeUniversitaire).subscribe({
          next: () => {
            Swal.fire(
              'Updated!',
              'Your Academic year has been updated.',
              'success'
            );
            // Redirect to the list or navigate to the desired page
            this.router.navigate(['/annee-universitaire']);
          },
          error: (error) => {
            console.error('Error updating academic year:', error);
          }
        });
      }
    }      
