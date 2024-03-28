import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Semestre } from '../../../models/semestre.module';
import { SemestresService } from '../../../services/semestres.service';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';
import { FilieresService } from '../../../services/filieres.service';
import { Filiere } from '../../../models/filiere.module';
import Swal from 'sweetalert2';
 

@Component({
  selector: 'app-edit-semestre',
  templateUrl: './edit-semestre.component.html',
  styleUrl: './edit-semestre.component.css'
})
export class EditSemestreComponent implements OnInit {
    anneesUniversitaires: AnneeUniversitaire[] = [];
    filieres: Filiere[] = [];
    selectedSemestre: Semestre = { id: 0,name: '', idAcademicYear: 0,
    session: '',
    typeSession: '',
    idFiliere: 0};

    constructor(
      private anneeUniversitaireService: AnneeUniversitaireService,
        private SemestreService: SemestresService ,
        private route: ActivatedRoute,
        private router: Router,
        private filiereService: FilieresService
    ) { }

    ngOnInit(): void {
      this.loadAnneesUniversitaires(); 
      this.loadFilieres();
        // Fetch the ID from the route parameters
        const semestreId = this.route.snapshot.params['id'];
      
        // Call the service to get the selected AnneeUniversitaire
        this.SemestreService.getSemestreById(semestreId).subscribe({
          next: (semestre: Semestre) => {
            this.selectedSemestre = semestre;
          },
          error: (error) => {
            console.error('Error fetching semester:', error);
          }
        });
      }
      onSemestreChange(): void {
        if (this.selectedSemestre.name === 'S1' || this.selectedSemestre.name === 'S3' || this.selectedSemestre.name === 'S5') {
          this.selectedSemestre.session = 'Automne';
        } else {
          this.selectedSemestre.session = 'Printemps';
        }
      }
      loadAnneesUniversitaires(): void {
        this.anneeUniversitaireService.getAllAnneesUniversitaires().subscribe(data => {
          this.anneesUniversitaires = data;
        });
      }
      loadFilieres(): void {
        this.filiereService.getAllFilieres().subscribe(data => {
          this.filieres = data;
        });}
      updateSmestre(): void {
        // Call the service to update  
        this.SemestreService.updateSemestre(this.selectedSemestre.id!, this.selectedSemestre).subscribe({
          next: () => {
            Swal.fire(
              'Updated!',
              'Your Semester has been updated.',
              'success'
            );
            // Redirect to the list or navigate to the desired page
            this.router.navigate(['/semestre']);
          },
          error: (error) => {
            console.error('Error updating semester:', error);
          }
        });
      }
    }      
