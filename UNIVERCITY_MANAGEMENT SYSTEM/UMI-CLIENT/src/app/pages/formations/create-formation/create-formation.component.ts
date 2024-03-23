import { Component, OnInit } from '@angular/core';
import { Formation } from './../../../models/formation.module';
import { FormationService } from '../../../services/formation.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-create-formation',
  templateUrl: './create-formation.component.html',
  styleUrl: './create-formation.component.css'
})
export class CreateFormationComponent implements OnInit {

    formations: Formation[] = [];
    newFormation: Formation = { intitule: '',typeFormation : '', responsable: '',
    // imageDescriptive:new ArrayBuffer(0)
    // ,
    documentDescriptifPath:'' };

    constructor(
        private formationService: FormationService,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.loadFormations();
    }

    loadFormations(): void {
        this.formationService.getAllFormations().subscribe(formations => {
            this.formations = formations;
        });
    }

    createFormation(): void {
        this.formationService.createFormation(this.newFormation).subscribe(() => {
            this.loadFormations();
            this.newFormation ={ intitule: '',typeFormation : '', responsable: '',
            // imageDescriptive:new ArrayBuffer(0),
            documentDescriptifPath:'' };

            Swal.fire(
                'Create!',
                'Your formation has been created successefully.',
                'success'
            );
            this.router.navigate(['/formations']);
        });
    }

    updateFormation(id: number, formation: Formation): void {

        this.formationService.updateFormation(id, formation).subscribe(() => {
            this.loadFormations();
        });
    }
    deleteFormations(id: number): void {
        this.formationService.deleteFormation(id).subscribe(() => {
            this.loadFormations();
        });
    }
    // onImageSelected(event: any): void {
    //   const file = event.target.files[0];
    //   if (file) {
    //     const reader = new FileReader();
    //     reader.readAsArrayBuffer(file);
    //     reader.onload = () => {
    //       this.newFormation.imageDescriptive = reader.result as ArrayBuffer;
    //     };
    //   }
    // }
  
    onDocumentSelected(event: any): void {
      const file = event.target.files[0];
      if (file) {
        this.newFormation.documentDescriptifPath = file.name;
      }
    }
}
