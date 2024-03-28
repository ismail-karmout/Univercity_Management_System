import { Component, OnInit } from '@angular/core';
import { Team } from '../../../models/team.module';
import { TeamService } from '../../../services/team.service';
import { LaboService } from '../../../services/labo.service';
import { Labo } from '../../../models/labo.module';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
    selector: 'app-create-team',
    templateUrl: './create-team.component.html',
    styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {
    teams: Team[] = [];
    rechercheAxes: RechercheAxe[] = [];
    departments: Department[] = [];
    labos: Labo[] = [];
    newTeam: Team = { title: '', slug: '', labo: { id: 0, acroname: '', title: '', slug: '' }, department_id: 0, rechercheAxes: [] };
    teamForm: FormGroup = new FormGroup({});
    rechercheAxesSelection: boolean[] = [];


    constructor(
        private teamService: TeamService,
        private laboService: LaboService,
        private departmentsService: DepartmentService,
        private rechercheAxesService: RechercheAxeSercice,
        private router: Router,
        private formBuilder: FormBuilder,
    ) { }

    createFormArray(): void {
        if (this.newTeam && this.newTeam.rechercheAxes) {
            this.newTeam.rechercheAxes.forEach(() => {
                const control = this.formBuilder.control(false);
                (this.teamForm.get('rechercheAxes') as FormArray).push(control);
            });
        }
    }
    ngOnInit(): void {
        this.loadRechercheAxes();
        this.loadLabos();
        this.loadDepartments();
        this.rechercheAxesSelection = Array(this.rechercheAxes.length).fill(false);

        // Initialize the form with default values from newTeam
        this.teamForm = this.formBuilder.group({
            name: [this.newTeam.title],
            slug: [this.newTeam.slug],
            labo: this.formBuilder.group({
                id: [this.newTeam.labo.id],
                acroname: [this.newTeam.labo.acroname],
                title: [this.newTeam.labo.title],
                slug: [this.newTeam.labo.slug]
            }),
            department_id: [this.newTeam.department_id],
            rechercheAxes: this.formBuilder.array([]),
        });
        this.createFormArray();
    }


    loadTeams(): void {
        this.teamService.getAllTeams().subscribe(teams => {
            this.teams = teams;
        });
    }

    loadDepartments(): void {
        this.departmentsService.getAllDepartments().subscribe(data => {
            this.departments = data;
        });
    }

    loadRechercheAxes(): void {
        this.rechercheAxesService.getAllRechercheAxes().subscribe(data => {
            this.rechercheAxes = data;
        });
    }

    updateRechercheAxes(index: number): void {
        // Update the corresponding element in the array
        this.rechercheAxesSelection[index] = !this.rechercheAxesSelection[index];
    }
    // Assuming that rechercheAxes is an array of objects with 'id' property

    createTeam(): void {

        console.log('================================');
        console.log(this.newTeam.rechercheAxes);

        this.newTeam.rechercheAxes = this.rechercheAxesSelection
            .map((selected, index): RechercheAxe | null => selected ? this.rechercheAxes[index] : null)
            .filter(value => value !== null) as RechercheAxe[];
            
        console.log('================================');
        console.log(this.newTeam.rechercheAxes);

        this.teamService.createTeam(this.newTeam).subscribe(
            () => {
                this.loadTeams();
                this.teamForm.reset();
                Swal.fire(
                    'Create!',
                    'Your Team has been created successfully.',
                    'success'
                );
                this.router.navigate(['/teams']);
            },
            (error) => {
                console.error('Error creating team:', error);
                // Handle error (e.g., show error message to the user)
            }
        );
    }

    loadLabos(): void {
        this.laboService.getAllLabos().subscribe(data => {
            this.labos = data;
            console.log("=====================================");
            console.log(data);
        });
    }

    updateTeam(id: number, team: Team): void {
        this.teamService.updateTeam(id, team).subscribe(() => {
            this.loadTeams();
        });
    }

    deleteTeam(id: number): void {
        this.teamService.deleteTeam(id).subscribe(() => {
            this.loadTeams();
        });
    }
}
