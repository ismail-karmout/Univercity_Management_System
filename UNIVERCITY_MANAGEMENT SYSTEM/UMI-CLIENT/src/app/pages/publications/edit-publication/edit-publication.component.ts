import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
  selector: 'app-edit-publication',
  templateUrl: './edit-publication.component.html',
  styleUrl: './edit-publication.component.css'
})
export class EditPublicationComponent implements OnInit {



  profs: Professor[] = [];
  teams: Team[] = [];
  annees: AnneeUniversitaire[] = [];
  labos: Labo[] = [];



  selectedPublication: Publication = {
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
    private route: ActivatedRoute,

    private professorService: ProfessorService,
    private anneeService: AnneeUniversitaireService,
    private teamService: TeamService,
    private laboService: LaboService

  ) { }


  ngOnInit(): void {



    this.loadProfessors();
    this.loadAnnees();
    this.loadTeams();
    this.loadLabos();

    // Fetch the ID from the route parameters
    const publicationId = this.route.snapshot.params['id'];

    // Call the service to get the selected AnneeUniversitaire
    this.publicationService.getPublicationById(publicationId).subscribe({
      next: (publication: Publication) => {
        this.selectedPublication = publication;
      },
      error: (error) => {
        console.error('Error fetching publication:', error);
      }
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



  updatePublication(): void {
    // Call the service to update  
    this.publicationService.updatePublication(this.selectedPublication.id!, this.selectedPublication).subscribe({
      next: () => {
        Swal.fire(
          'Updated!',
          'Your  Publication has been updated.',
          'success'
        );
        // Redirect to the list or navigate to the desired page
        this.router.navigate(['/publication']);
      },
      error: (error) => {
        console.error('Error updating publication:', error);
      }
    });
  }
  onDocumentSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedPublication.justificatif = file.name;
    }
  }
}


