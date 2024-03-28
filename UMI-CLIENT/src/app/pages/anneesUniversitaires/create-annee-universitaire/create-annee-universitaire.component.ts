import { Component, OnInit } from '@angular/core';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-annee-universitaire',
  templateUrl: './create-annee-universitaire.component.html',
  styleUrls: ['./create-annee-universitaire.component.css']
})
export class CreateAnneeUniversitaireComponent implements OnInit {
  anneesUniversitaires: AnneeUniversitaire[] = [];
  newAnneeUniversitaire: AnneeUniversitaire = {
    courante: '',
    startYear: '',
    endYear: ''
    
  };

  constructor(
    private anneeUniversitaireService: AnneeUniversitaireService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadAnneesUniversitaires();
  }

  createAnneeUniversitaire(): void {
    this.anneeUniversitaireService.createAnneeUniversitaire(this.newAnneeUniversitaire).subscribe(() => {
      this.newAnneeUniversitaire = {
        courante: '',
        startYear: '',
        endYear: '' 
      };
      Swal.fire(
        'Create!',
        'Your Academic year has been created successfully.',
        'success'
      );
      this.router.navigate(['/anneesUniversitaires']);  
    });
  }
  updateEndYear() {
    this.newAnneeUniversitaire.endYear = this.newAnneeUniversitaire.startYear + 1;
  }
  
  traitement(): void {
    // Effectuez le traitement des informations du formulaire ici
    console.log('Traitement des informations du formulaire...');
  }
  loadAnneesUniversitaires(): void {
    this.anneeUniversitaireService.getAllAnneesUniversitaires().subscribe(data => {
      this.anneesUniversitaires = data;
    });
  }

  updateAnneeUniversitaire(id: number, anneeUniversitaire: AnneeUniversitaire): void {
    this.anneeUniversitaireService.updateAnneeUniversitaire(id, anneeUniversitaire).subscribe(() => {
      this.loadAnneesUniversitaires();
      Swal.fire('Update!', 'Academic year has been updated successfully.', 'success');
    });
  }

  deleteAnneeUniversitaire(id: number): void {
    this.anneeUniversitaireService.deleteAnneeUniversitaire(id).subscribe(() => {
      this.loadAnneesUniversitaires();
      Swal.fire('Delete!', 'Academic year has been deleted successfully.', 'success');
    });
  }
}
