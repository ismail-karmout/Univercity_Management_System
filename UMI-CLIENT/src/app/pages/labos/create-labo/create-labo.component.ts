import { Component, OnInit } from '@angular/core';
import { LaboService } from '../../../services/labo.service';
import { Labo } from '../../../models/labo.module';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { EcoleDoctoraleService } from '../../../services/ecole-doctorale.service';
import { EcoleDoctorale } from '../../../models/ecole-doctorale.module';

@Component({
    selector: 'app-create-labo',
    templateUrl: './create-labo.component.html',
    styleUrls: ['./create-labo.component.css']
})

export class CreateLaboComponent implements OnInit {
    labos: Labo[] = [];
    rechercheAxes: RechercheAxe[] = [];
    ecoleDoctorales: EcoleDoctorale[] = [];
    departments: Department[] = [];
    newLabo: Labo = { title: '', acroname: '', slug: '', department_id: 0, ecole_doctorale_id: 0, rechercheAxes: [] };
    laboForm: FormGroup = new FormGroup({});
    rechercheAxesSelection: boolean[] = [];


    constructor(
        private laboService: LaboService,
        private departmentsService: DepartmentService,
        private ecoleDoctoraleService: EcoleDoctoraleService,
        private rechercheAxesService: RechercheAxeSercice,
        private router: Router,
        private formBuilder: FormBuilder,
    ) { }

    createFormArray(): void {
        if (this.newLabo && this.newLabo.rechercheAxes) {
            this.newLabo.rechercheAxes.forEach(() => {
                const control = this.formBuilder.control(false);
                (this.laboForm.get('rechercheAxes') as FormArray).push(control);
            });
        }
    }
    ngOnInit(): void {
        this.loadRechercheAxes();
        this.loadDepartments();
        this.loadEcoleDoctorales(); 
        this.rechercheAxesSelection = Array(this.rechercheAxes.length).fill(false);

        // Initialize the form with default values from newLabo
        this.laboForm = this.formBuilder.group({
            name: [this.newLabo.title],
            slug: [this.newLabo.slug],
            department_id: [this.newLabo.department_id],
            ecole_doctorale_id: [this.newLabo.ecole_doctorale_id],
            rechercheAxes: this.formBuilder.array([]),
        });
        this.createFormArray();
    }

    loadDepartments(): void {
        this.departmentsService.getAllDepartments().subscribe(data => {
            this.departments = data;
        });
    }
    loadEcoleDoctorales(): void {
        this.ecoleDoctoraleService.getAllEcoleDoctorales().subscribe(data => {
            this.ecoleDoctorales = data;
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

    createLabo(): void {

        console.log('================================');
        console.log(this.newLabo.rechercheAxes);

        this.newLabo.rechercheAxes = this.rechercheAxesSelection
            .map((selected, index): RechercheAxe | null => selected ? this.rechercheAxes[index] : null)
            .filter(value => value !== null) as RechercheAxe[];

        console.log('================================');
        console.log(this.newLabo.rechercheAxes);

        this.laboService.createLabo(this.newLabo).subscribe(
            () => {
                this.laboForm.reset();
                Swal.fire(
                    'Create!',
                    'Your labo has been created successfully.',
                    'success'
                );
                this.router.navigate(['/labos']);
            },
            (error) => {
                console.error('Error creating labo:', error);
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
}
