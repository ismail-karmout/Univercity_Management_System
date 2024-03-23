import { Component, OnInit } from '@angular/core';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
    selector: 'app-recherche-axe',
    templateUrl: './create-recherche-axe.component.html',
    styleUrls: ['./create-recherche-axe.component.css']
})
export class CreateRechercheAxeComponent implements OnInit {
    rechercheAxes: RechercheAxe[] = [];
    newRechercheAxe: RechercheAxe = { name: '', slug: '' };

    constructor(
        private rechercheAxeService: RechercheAxeSercice,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.loadRechercheAxes();
    }

    loadRechercheAxes(): void {
        this.rechercheAxeService.getAllRechercheAxes().subscribe(RechercheAxes => {
            this.rechercheAxes = RechercheAxes;
        });
    }

    createRechercheAxe(): void {
        this.rechercheAxeService.createRechercheAxe(this.newRechercheAxe).subscribe(() => {
            this.loadRechercheAxes();
            this.newRechercheAxe = { name: '', slug: '' };
            Swal.fire(
                'Creatde!',
                'Your recherche recherche axe has been created.',
                'success'
            );
            this.router.navigate(['/recherche-axes']);
        });
    }

    updateRechercheAxe(id: number, RechercheAxe: RechercheAxe): void {
        this.rechercheAxeService.updateRechercheAxe(id, RechercheAxe).subscribe(() => {
            this.loadRechercheAxes();
        });
    }
    deleteRechercheAxe(id: number): void {
        this.rechercheAxeService.deleteRechercheAxe(id).subscribe(() => {
            this.loadRechercheAxes();
        });
    }
}
