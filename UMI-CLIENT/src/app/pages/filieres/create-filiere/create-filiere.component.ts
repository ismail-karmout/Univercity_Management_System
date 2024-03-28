import { Component, OnInit } from '@angular/core';
import { Filiere } from '../../../models/filiere.module';
import { FilieresService } from '../../../services/filieres.service';
import { Router } from '@angular/router';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';
 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-filiere',
  templateUrl: './create-filiere.component.html',
  styleUrl: './create-filiere.component.css'
})
export class CreateFiliereComponent  implements OnInit {

   // Déclarez les variables selectedFiliereId et selectedAcademicYear
  selectedDepartmentId: any = 0;
   
  departments: Department[] = [];
  filieres: Filiere[] = [];
  newFiliere: Filiere = {
    name: '',
    nbAnnees: 0,
    nbSemestres: 0,
    responsable: '',
    anneeDiplomante: '',
    anneesNonDiplomantes:'',
    slug:'',
    department_id: 0

    
  };

  constructor(
  
    private departmentService: DepartmentService,
    private router: Router,
    private filiereService: FilieresService
  ) {}

  ngOnInit(): void {
    this.loadDepartments(); 
    this.loadFilieres();
   
  }

  createFiliere(): void {
  
    this.newFiliere.department_id = this.selectedDepartmentId;  

    this.filiereService.addFiliere(this.newFiliere).subscribe(() => {
      this.newFiliere = {
        name: '',
        nbAnnees: 0,
        nbSemestres: 0,
        responsable: '',
        anneeDiplomante: '',
        anneesNonDiplomantes:'',
        slug:'',
        department_id: 0
      };
      Swal.fire(
        'Create!',
        'Your Filiere has been created successfully.',
        'success'
      );
      this.router.navigate(['/filiere']);
    });
  }
  
  traitement(): void {
    // Effectuez le traitement des informations du formulaire ici
    console.log('Traitement des informations du formulaire...');
  }
  loadFilieres(): void {
    this.filiereService.getAllFilieres().subscribe(data => {
      this.filieres = data;
    });
  }
  loadDepartments(): void {
    this.departmentService.getAllDepartments().subscribe(data => {
      this.departments = data;
    });
  }
  
  updateFiliere(id: number, filiere: Filiere): void {
    this.filiereService.updateFiliere(id, filiere).subscribe(() => {
      this.loadFilieres();
      Swal.fire('Update!', 'Filiere has been updated successfully.', 'success');
    });
  }

  deleteFiliere(id: number): void {
    this.filiereService.deleteFiliere(id).subscribe(() => {
      this.loadFilieres();
      Swal.fire('Delete!', 'Filiere has been deleted successfully.', 'success');
    });
  }
}

