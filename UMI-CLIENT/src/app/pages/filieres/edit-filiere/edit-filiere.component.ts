import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
 import { FilieresService } from '../../../services/filieres.service';
import { Filiere } from '../../../models/filiere.module';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-filiere',
  templateUrl: './edit-filiere.component.html',
  styleUrl: './edit-filiere.component.css'
})
export class EditFiliereComponent implements OnInit {

     
    departments: Department[] = [];
    selectedFiliere: Filiere = { 
       name: '',
    nbAnnees: 0,
    nbSemestres: 0,
    responsable: '',
    anneeDiplomante: '',
    anneesNonDiplomantes:'',
    slug:'',
    department_id: 0
    }
    constructor(
        private departmentService: DepartmentService,
        private route: ActivatedRoute,
        private router: Router,
        private filiereService: FilieresService
    ) { }

    ngOnInit(): void {
       
      this.loadDepartments();
        // Fetch the ID from the route parameters
        const filiereId = this.route.snapshot.params['id'];
      
        // Call the service to get the selected AnneeUniversitaire
        this.filiereService.getFiliereById(filiereId).subscribe({
          next: (filiere: Filiere) => {
            this.selectedFiliere = filiere;
          },
          error: (error) => {
            console.error('Error fetching filiere:', error);
          }
        });
      }
      
      
      loadDepartments(): void {
        this.departmentService.getAllDepartments().subscribe(data => {
          this.departments= data;
        });}

      updateFiliere(): void {
        // Call the service to update  
        this.filiereService.updateFiliere(this.selectedFiliere.id!, this.selectedFiliere).subscribe({
          next: () => {
            Swal.fire(
              'Updated!',
              'Your Filiere has been updated.',
              'success'
            );
            // Redirect to the list or navigate to the desired page
            this.router.navigate(['/filiere']);
          },
          error: (error) => {
            console.error('Error updating filiere:', error);
          }
        });
      }
    }      

