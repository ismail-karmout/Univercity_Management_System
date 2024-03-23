import { Component, OnInit } from '@angular/core';
import { Semestre } from '../../../models/semestre.module';
import { SemestresService } from '../../../services/semestres.service';
import { Router } from '@angular/router';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';
import { FilieresService } from '../../../services/filieres.service';
import { Filiere } from '../../../models/filiere.module';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-semestre',
  templateUrl: './create-semestre.component.html',
  styleUrl: './create-semestre.component.css'
})
export class CreateSemestreComponent implements OnInit {

   // Déclarez les variables selectedFiliereId et selectedAcademicYear
selectedFiliereId: any = 0;
   // Déclarez la variable selectedAcademicYear avec son type
selectedAcademicYearId: any = 0;
  anneesUniversitaires: AnneeUniversitaire[] = [];
  semestres: Semestre[] = [];
  filieres: Filiere[] = [];
  newSemestre: Semestre = {
    name: '',
    idAcademicYear: 0,
    session: '',
    typeSession: '',
    idFiliere: 0

    
  };

  constructor(
    private anneeUniversitaireService: AnneeUniversitaireService,
    private semestreService: SemestresService,
    private router: Router,
    private filiereService: FilieresService
  ) {}

  ngOnInit(): void {
    this.loadSemestres();
    this.loadAnneesUniversitaires(); 
    this.loadFilieres();
   
  }

  createSemestre(): void {
    // Logique pour déterminer automatiquement la session en fonction du semestre
    if (this.newSemestre.name === 'S1' || this.newSemestre.name === 'S3' || this.newSemestre.name === 'S5') {
      this.newSemestre.session = 'Automne';
    } else {
      this.newSemestre.session = 'Printemps';
    }
    this.newSemestre.idFiliere = this.selectedFiliereId;
    this.newSemestre.idAcademicYear = this.selectedAcademicYearId; // Utilisez l'identifiant sélectionné
  
    // Enregistrer le semestre en appelant le service
    this.semestreService.createSemestre(this.newSemestre).subscribe(() => {
      this.newSemestre = {
        name: '',
        idAcademicYear: 0,
        session: '',
        typeSession: '',
        idFiliere: 0
      };
      Swal.fire(
        'Create!',
        'Your Semester has been created successfully.',
        'success'
      );
      this.router.navigate(['/semestres']);
    });
  }
  
   
  onSemestreChange(): void {
    if (this.newSemestre.name === 'S1' || this.newSemestre.name === 'S3' || this.newSemestre.name === 'S5') {
      this.newSemestre.session = 'Automne';
    } else {
      this.newSemestre.session = 'Printemps';
    }
  }
  traitement(): void {
    // Effectuez le traitement des informations du formulaire ici
    console.log('Traitement des informations du formulaire...');
  }
  loadSemestres(): void {
    this.semestreService.getAllSemestres().subscribe(data => {
      this.semestres = data;
    });
  }
  loadAnneesUniversitaires(): void {
    this.anneeUniversitaireService.getAllAnneesUniversitaires().subscribe(data => {
      this.anneesUniversitaires = data;
    });
  }
  loadFilieres(): void {
    this.filiereService.getAllFilieres().subscribe(data => {
      this.filieres = data;
    });
  }
  updateSemestre(id: number, semestre: Semestre): void {
    this.semestreService.updateSemestre(id, semestre).subscribe(() => {
      this.loadSemestres();
      Swal.fire('Update!', 'Semester has been updated successfully.', 'success');
    });
  }

  deleteSemestre(id: number): void {
    this.semestreService.deleteSemestre(id).subscribe(() => {
      this.loadSemestres();
      Swal.fire('Delete!', 'Semester has been deleted successfully.', 'success');
    });
  }
}
