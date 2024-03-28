import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

import { Publication } from '../../../models/publication.model';
import { PublicationService } from '../../../services/publication.service';

import { Professor } from '../../../models/professor.model';
import { AnneeUniversitaire } from '../../../models/anneeUniversitaire.module';
import { Labo } from '../../../models/labo.module';
import { Team } from '../../../models/team.module';
import { LaboService } from '../../../services/labo.service';
import { TeamService } from '../../../services/team.service';
import { ProfessorService } from '../../../services/professor.service';
import { AnneeUniversitaireService } from '../../../services/annee-universitaires.service';

@Component({
  selector: 'app-create-publication',
  templateUrl: './create-publication.component.html',
  styleUrl: './create-publication.component.css'
})
export class CreatePublicationComponent implements OnInit {


  selectedProfId: any = 0;
  selectedAnneeId: any = 0;
  selectedTeamId: any = 0;
  selectedLaboId: any = 0;

  profs: Professor[] = [];
  teams: Team[] = [];
  annees: AnneeUniversitaire[] = [];
  labos: Labo[] = [];


  publications: Publication[] = [];
  newPublication: Publication = {
    type: '',
    titre: '',
    auteurId: 0,
    anneeUniversitaireId: 0,
    equipeId: 0,
    laboId: 0,
    etat: '',
    justificatif: ''


  };

  constructor(

    private publicationService: PublicationService,
    private router: Router,


    private professorService: ProfessorService,
    private anneeService: AnneeUniversitaireService,
    private teamService: TeamService,
    private laboService: LaboService

  ) { }

  ngOnInit(): void {
    this.loadPublications();

    this.loadProfessors();
    this.loadAnnees();
    this.loadTeams();
    this.loadLabos();


  }

  createPublication(): void {

    this.newPublication.auteurId = this.selectedProfId;
    this.newPublication.anneeUniversitaireId = this.selectedAnneeId;
    this.newPublication.equipeId = this.selectedTeamId;
    this.newPublication.laboId = this.selectedLaboId;

    this.publicationService.addPublication(this.newPublication).subscribe(() => {
      this.newPublication = {
        type: '',
        titre: '',
        auteurId: 0,
        anneeUniversitaireId: 0,
        equipeId: 0,
        laboId: 0,
        etat: '',
        justificatif: ''
      };
      Swal.fire(
        'Create!',
        'Your Publication has been created successfully.',
        'success'
      );
      this.router.navigate(['/publications']);
    });
  }

  traitement(): void {
    // Effectuez le traitement des informations du formulaire ici
    console.log('Traitement des informations du formulaire...');
  }
  loadPublications(): void {
    this.publicationService.getAllPublications().subscribe(data => {
      this.publications = data;
    });
  }



  loadProfessors(): void {
    this.professorService.getAllProfessors().subscribe(data => {
      this.profs = data;
    });
  }
  loadAnnees(): void {
    this.anneeService.getAllAnneesUniversitaires().subscribe(data => {
      this.annees = data;
    });
  }
  loadTeams(): void {
    this.teamService.getAllTeams().subscribe(data => {
      this.teams = data;
    });
  }
  loadLabos(): void {
    this.laboService.getAllLabos().subscribe(data => {
      this.labos = data;
    });
  }




  updatePublication(id: number, publication: Publication): void {
    this.publicationService.updatePublication(id, publication).subscribe(() => {
      this.loadPublications();
      Swal.fire('Update!', 'Publication has been updated successfully.', 'success');
    });
  }

  deletePublication(id: number): void {
    this.publicationService.deletePublication(id).subscribe(() => {
      this.loadPublications();
      Swal.fire('Delete!', 'Publication has been deleted successfully.', 'success');
    });
  }
  onDocumentSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.newPublication.justificatif = file.name;
    }
  }
}

