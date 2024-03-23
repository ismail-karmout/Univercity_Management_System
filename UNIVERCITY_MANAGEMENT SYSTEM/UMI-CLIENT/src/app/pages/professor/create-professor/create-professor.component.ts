import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProfessorService } from '../../../services/professor.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Labo } from '../../../models/labo.module';
import { Team } from '../../../models/team.module';
import { LaboService } from '../../../services/labo.service';
import { TeamService } from '../../../services/team.service';

@Component({
  selector: 'app-create-professor',
  templateUrl: './create-professor.component.html',
  styleUrl: './create-professor.component.css'
})
export class CreateProfessorComponent {
  professorFormGroup!: FormGroup;
  labos!: Labo[];
  teams!: Team[];

  constructor(
    private professorService: ProfessorService,
    private laboService: LaboService,
    private teamService: TeamService,
    private router: Router,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.professorFormGroup = this.fb.group({
      firstname: this.fb.control(null, [Validators.required]),
      lastname: this.fb.control(null, [Validators.required]),
      email: this.fb.control(null, [Validators.required]),
      phone: this.fb.control(null, [Validators.required]),
      laboId: this.fb.control(null),
      teamId: this.fb.control(null)
    });

    this.laboService.getAllLabos().subscribe(
      data => {
        this.labos = data
        console.log(this.labos)
      }
    );

    this.teamService.getAllTeams().subscribe(
      data => {
        this.teams = data
      }
    );
  }

  handleCreateProfessor() {
    let professor = this.professorFormGroup.value;
    this.professorService.saveProfessor(professor).subscribe({
      next: data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.professorFormGroup.reset()
      },
      error: err => {
        console.log(err);
      }
    })
  }



  handleCancel() {
    this.router.navigate(['/professors']);
  }

}
