import { Component } from '@angular/core';
import { EcoleDoctoraleService } from '../../../services/ecole-doctorale.service';
import { EcoleDoctorale } from '../../../models/ecole-doctorale.module';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-ecole-doctorale',
  templateUrl: './create-ecole-doctorale.component.html',
  styleUrl: './create-ecole-doctorale.component.css'
})
export class CreateEcoleDoctoraleComponent {
  newEcoleDoctorale: EcoleDoctorale = { name: '', description: '', slug: '' };
  constructor(
    private ecoleDoctoraleService: EcoleDoctoraleService,
    private router: Router
  ) { }
  createEcoleDoctrale(): void {
    this.ecoleDoctoraleService.createEcoleDoctorale(this.newEcoleDoctorale).subscribe(() => {
      this.newEcoleDoctorale = { name: '', description: '', slug: '' };
      Swal.fire(
        'Create!',
        'Your Ecole Doctorale has been created successefully.',
        'success'
      );
      this.router.navigate(['/ecole-doctorale']); // Adjust the route based on your actual route configuration
    });
  }
}
