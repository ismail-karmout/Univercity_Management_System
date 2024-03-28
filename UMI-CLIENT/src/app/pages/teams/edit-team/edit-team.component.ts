import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { Team } from '../../../models/team.module';
import { TeamService } from '../../../services/team.service';
import { Labo } from '../../../models/labo.module';
import { LaboService } from '../../../services/labo.service';
import Swal from 'sweetalert2';
import { DepartmentService } from '../../../services/department.service';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { Department } from '../../../models/department.module';

@Component({
    selector: 'app-team-edit',
    templateUrl: './edit-team.component.html',
    styleUrls: ['./edit-team.component.css']
})

export class EditTeamComponent implements OnInit {
    teamForm: FormGroup;
    rechercheAxes: RechercheAxe[] = [];
    departments: Department[] = [];
    labos: Labo[] = [];
    selectedTeam: Team = { title: '', slug: '', labo: { id: 0, acroname: '', title: '', slug: '' }, department_id: 0, rechercheAxes: [] };
    selectedRechercheAxes: boolean[] = [];

    constructor(
        private teamService: TeamService,
        private laboService: LaboService,
        private departmentsService: DepartmentService,
        private rechercheAxesService: RechercheAxeSercice,
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder
    ) {
        this.teamForm = this.formBuilder.group({
            title: ['', Validators.required],
            slug: ['', Validators.required],
            labo: this.formBuilder.group({
                id: [''],
                acroname: [''],
                title: [''],
                slug: ['']
            }),
            department_id: ['', Validators.required],
            rechercheAxes: this.formBuilder.array([]),
            // Add other form controls as needed
        });
    }

    ngOnInit(): void {
        const teamId = this.route.snapshot.params['id'];

        this.teamService.getTeamById(teamId).subscribe(
            (team: Team) => {
                this.selectedTeam = team;
                this.populateForm();
            },
            (error) => {
                console.error('Error fetching Team:', error);
            }
        );

        this.loadLabos();
        this.loadDepartments();
        this.loadRechercheAxes();
    }

    populateForm(): void {
        this.teamForm.patchValue({
            title: this.selectedTeam.title,
            slug: this.selectedTeam.slug,
            labo: {
                id: this.selectedTeam.labo.id,
                acroname: this.selectedTeam.labo.acroname,
                title: this.selectedTeam.labo.title,
                slug: this.selectedTeam.labo.slug
            },
            department_id: this.selectedTeam.department_id,
        });

        this.populateRechercheAxes();
    }

    populateRechercheAxes(): void {
        const rechercheAxesArray = this.teamForm.get('rechercheAxes') as FormArray;
        this.selectedRechercheAxes = Array(this.rechercheAxes.length).fill(false);

        if (this.selectedTeam.rechercheAxes) {
            this.selectedTeam.rechercheAxes.forEach(selectedRechercheAxe => {
                const index = this.rechercheAxes.findIndex(ra => ra.id === selectedRechercheAxe.id);
                if (index !== -1) {
                    this.selectedRechercheAxes[index] = true;
                    rechercheAxesArray.at(index).setValue(true);
                }
            });
        }
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

    loadLabos(): void {
        this.laboService.getAllLabos().subscribe(data => {
            this.labos = data;
        });
    }

    updateSelectedRechercheAxes(index: number): void {
        this.selectedRechercheAxes[index] = !this.selectedRechercheAxes[index];
        const rechercheAxesArray = this.teamForm.get('rechercheAxes') as FormArray;
        rechercheAxesArray.at(index).setValue(this.selectedRechercheAxes[index]);
    }

    updateTeam(): void {
        const updatedTeam: Team = this.teamForm.value;
        updatedTeam.rechercheAxes = this.rechercheAxes.filter(
            (ra, index) => this.selectedRechercheAxes[index]
        );

        this.teamService.updateTeam(this.selectedTeam.id!, updatedTeam).subscribe(
            () => {
                Swal.fire(
                    'Update!',
                    'Your Team has been updated successfully.',
                    'success'
                );
                this.router.navigate(['/teams']);
            },
            (error) => {
                console.error('Error updating team:', error);
            }
        );
    }
}
