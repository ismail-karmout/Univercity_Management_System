import { Component, OnInit } from '@angular/core';
import { Etablissement } from './../../../models/etablissement.module';
import { EtablissementService } from '../../../services/etablissement.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-etablissement',
    templateUrl: './create-etablissement.component.html',
    styleUrls: ['./create-etablissement.component.css']
})
export class CreateEtablissementComponent implements OnInit {
    etablissements: Etablissement[] = [];
    newEtablissement: Etablissement = { name: '', description: '', slug: '' };

    constructor(
        private etablissementService: EtablissementService,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.loadEtablissements();
    }

    loadEtablissements(): void {
        this.etablissementService.getAllEtablissements().subscribe(etablissements => {
            this.etablissements = etablissements;
        });
    }

    createEtablissement(): void {
        this.etablissementService.createEtablissement(this.newEtablissement).subscribe(() => {
            this.loadEtablissements();
            this.newEtablissement = { name: '', description: '', slug: '' };
            Swal.fire(
                'Create!',
                'Your etablissement has been created successefully.',
                'success'
            );
            this.router.navigate(['/etablissements']);
        });
    }

    updateEtablissement(id: number, etablissement: Etablissement): void {
        this.etablissementService.updateEtablissement(id, etablissement).subscribe(() => {
            this.loadEtablissements();
        });
    }
    deleteEtablissement(id: number): void {
        this.etablissementService.deleteEtablissement(id).subscribe(() => {
            this.loadEtablissements();
        });
    }
}
