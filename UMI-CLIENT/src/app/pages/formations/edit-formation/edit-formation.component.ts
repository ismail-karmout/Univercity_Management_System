import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Formation} from '../../../models/formation.module';
import { FormationService } from '../../../services/formation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-formation',
  templateUrl: './edit-formation.component.html',
  styleUrl: './edit-formation.component.css'
})
export class EditFormationComponent  implements OnInit {

    selectedFormation: Formation = { intitule: '',typeFormation : '', responsable: '',
    // imageDescriptive:new ArrayBuffer(0)
    // ,
    documentDescriptifPath:'' };

    constructor(
        private formationService: FormationService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit(): void {
        // Fetch the Etablissement ID from the route parameters
        const formationId = this.route.snapshot.params['id'];

        // Call the service to get the selected Etablissement
        this.formationService.getFormationById(formationId).subscribe(
            (formation: Formation) => {
                this.selectedFormation =formation;
            },
            (error) => {
                console.error('Error fetching Formation:', error);
            }
        );
    }

    updateFormation(): void { 
        this.formationService.updateFormation(this.selectedFormation.id!, this.selectedFormation).subscribe(
            () => {
                Swal.fire(
                    'Update!',
                    'Your formation has been updated successefully.',
                    'success'
                );
                // Redirect to the Etablissements list or navigate to the desired page
                this.router.navigate(['/formations']);
            },
            (error) => {
                console.error('Error updating Formation:', error);
            }
        );
    }
     // onImageSelected(event: any): void {
    //   const file = event.target.files[0];
    //   if (file) {
    //     const reader = new FileReader();
    //     reader.readAsArrayBuffer(file);
    //     reader.onload = () => {
    //       this.selectedFormation.imageDescriptive = reader.result as ArrayBuffer;
    //     };
    //   }
    // }
  
    onDocumentSelected(event: any): void {
      const file = event.target.files[0];
      if (file) {
        this.selectedFormation.documentDescriptifPath = file.name;
      }
    }
}
