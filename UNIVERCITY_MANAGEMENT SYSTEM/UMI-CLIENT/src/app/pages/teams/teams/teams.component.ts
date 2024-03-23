// teams.component.ts
import { Component, OnInit } from '@angular/core';
import { TeamService } from '../../../services/team.service';
import { Team } from '../../../models/team.module';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {
  teams: Team[] = [];
  teamForm: FormGroup;

  constructor(
    private teamService: TeamService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.teamForm = this.formBuilder.group({
      // Define your form controls here based on your team model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadteams();
  }

  loadteams(): void {
    this.teamService.getAllTeams().subscribe(data => {
      this.teams = data;
    });
  }

  deleteTeam(teamId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this team!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the teamService to delete the team
        this.teamService.deleteTeam(teamId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your team has been deleted.',
              'success'
            );
            // Refresh the local list of teams after deletion
            this.teams = this.teams.filter(team => team.id !== teamId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting team:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the team.',
              'error'
            );
          }
        );
      }
    });
  }

  editTeam(teamId: number): void {
    console.log('team ID:', teamId);

    if (teamId) {
      this.router.navigate(['/teams/edit', teamId]);
    }
  }
}
