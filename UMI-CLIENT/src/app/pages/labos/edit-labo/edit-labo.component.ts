import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { Labo } from '../../../models/labo.module';
import { LaboService } from '../../../services/labo.service';
import Swal from 'sweetalert2';
import { DepartmentService } from '../../../services/department.service';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { Department } from '../../../models/department.module';
import { EcoleDoctoraleService } from '../../../services/ecole-doctorale.service';
import { EcoleDoctorale } from '../../../models/ecole-doctorale.module';

@Component({
    selector: 'app-labo-edit',
    templateUrl: './edit-labo.component.html',
    styleUrls: ['./edit-labo.component.css']
})

export class EditLaboComponent implements OnInit {
    laboForm: FormGroup;
    rechercheAxes: RechercheAxe[] = [];
    departments: Department[] = [];
    ecoleDoctorales: EcoleDoctorale[] = [];
    labos: Labo[] = [];
    selectedLabo: Labo = { title: '', acroname: '', slug: '', ecole_doctorale_id: 0, department_id: 0, rechercheAxes: [] };
    selectedRechercheAxes: boolean[] = [];

    constructor(
        private laboService: LaboService,
        private ecoleDoctoraleService: EcoleDoctoraleService,
        private departmentsService: DepartmentService,
        private rechercheAxesService: RechercheAxeSercice,
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder
    ) {
        this.laboForm = this.formBuilder.group({
            title: ['', Validators.required],
            acroname: ['', Validators.required],
            slug: ['', Validators.required],
            ecole_doctorale: ['', Validators.required],
            department_id: ['', Validators.required],
            rechercheAxes: this.formBuilder.array([]),
            // Add other form controls as needed
        });
    }

    ngOnInit(): void {
        const laboId = this.route.snapshot.params['id'];

        this.laboService.getLaboById(laboId).subscribe(
            (labo: Labo) => {
                this.selectedLabo = labo;
                this.populateForm();
            },
            (error) => {
                console.error('Error fetching labo:', error);
            }
        );

        this.loadDepartments();
        this.loadRechercheAxes();
        this.loadEcoleDoctorale();
    }

    populateForm(): void {
        this.laboForm.patchValue({
            title: this.selectedLabo.title,
            acroname: this.selectedLabo.acroname,
            slug: this.selectedLabo.slug,
            ecole_doctorale_id: this.selectedLabo.ecole_doctorale_id,
            department_id: this.selectedLabo.department_id,
        });

        // this.populateRechercheAxes();
    }

    populateRechercheAxes(): void {
        const rechercheAxesArray = this.laboForm.get('rechercheAxes') as FormArray;
        this.selectedRechercheAxes = Array(this.rechercheAxes.length).fill(false);

        if (this.selectedLabo.rechercheAxes) {
            this.selectedLabo.rechercheAxes.forEach(selectedRechercheAxe => {
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

    loadEcoleDoctorale(): void {
        this.ecoleDoctoraleService.getAllEcoleDoctorales().subscribe(data => {
            this.ecoleDoctorales = data;
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
        const rechercheAxesArray = this.laboForm.get('rechercheAxes') as FormArray;
        rechercheAxesArray.at(index).setValue(this.selectedRechercheAxes[index]);
    }

    updateLabo(): void {
        const updatedlabo: Labo = this.laboForm.value;
        updatedlabo.rechercheAxes = this.rechercheAxes.filter(
            (ra, index) => this.selectedRechercheAxes[index]
        );

        this.laboService.updateLabo(this.selectedLabo.id!, updatedlabo).subscribe(
            () => {
                Swal.fire(
                    'Update!',
                    'Your labo has been updated successfully.',
                    'success'
                );
                this.router.navigate(['/labos']);
            },
            (error) => {
                console.error('Error updating labo:', error);
            }
        );
    }
}
