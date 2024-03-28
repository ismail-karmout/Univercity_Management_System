import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etablissement } from '../../../models/etablissement.module';
import { EtablissementService } from './../../../services/etablissement.service';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-etablissement-edit',
    templateUrl: './edit-etablissement.component.html',
    styleUrls: ['./edit-etablissement.component.css']
})
export class EditEtablissementComponent implements OnInit {
    selectedEtablissement: Etablissement = { id: 0, name: '', description: '', slug: '' };

    constructor(
        private etablissementService: EtablissementService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit(): void {
        // Fetch the Etablissement ID from the route parameters
        const etablissementId = this.route.snapshot.params['id'];

        // Call the service to get the selected Etablissement
        this.etablissementService.getEtablissementById(etablissementId).subscribe(
            (etablissement: Etablissement) => {
                this.selectedEtablissement = etablissement;
            },
            (error) => {
                console.error('Error fetching Etablissement:', error);
            }
        );
    }

    updateEtablissement(): void {
        // Call the service to update the Etablissement
        this.etablissementService.updateEtablissement(this.selectedEtablissement.id!, this.selectedEtablissement).subscribe(
            () => {
                Swal.fire(
                    'Update!',
                    'Your etablissement has been updated successefully.',
                    'success'
                );
                // Redirect to the Etablissements list or navigate to the desired page
                this.router.navigate(['/etablissements']);
            },
            (error) => {
                console.error('Error updating Etablissement:', error);
            }
        );
    }
}
