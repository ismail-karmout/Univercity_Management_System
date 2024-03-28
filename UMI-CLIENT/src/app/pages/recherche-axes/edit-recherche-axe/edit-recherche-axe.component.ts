import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-recherche-axe-edit',
    templateUrl: './edit-recherche-axe.component.html',
    styleUrls: ['./edit-recherche-axe.component.css']
})
export class EditRechercheAxeComponent implements OnInit {
    selectedRechercheAxe: RechercheAxe = { id: 0, name: '', slug: '' };

    constructor(
        private rechercheAxeSercice: RechercheAxeSercice,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit(): void {
        // Fetch the RechercheAxe ID from the route parameters
        const rechercheAxesId = this.route.snapshot.params['id'];

        // Call the service to get the selected RechercheAxe
        this.rechercheAxeSercice.getRechercheAxeById(rechercheAxesId).subscribe(
            (rechercheAxe: RechercheAxe) => {
                this.selectedRechercheAxe = rechercheAxe;
            },
            (error) => {
                console.error('Error fetching RechercheAxe:', error);
            }
        );
    }

    updateRechercheAxe(): void {
        // Call the service to update the RechercheAxe
        this.rechercheAxeSercice.updateRechercheAxe(this.selectedRechercheAxe.id!, this.selectedRechercheAxe).subscribe(
            () => {
                Swal.fire(
                    'Updated!',
                    'Your recherche recherche axe has been updated.',
                    'success'
                );
                // Redirect to the RechercheAxes list or navigate to the desired page
                this.router.navigate(['/recherche-axes']);
            },
            (error) => {
                console.error('Error updating Recherche Axe:', error);
            }
        );
    }
}
