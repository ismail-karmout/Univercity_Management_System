// ecole-doctorale.component.ts
import { Component, OnInit } from '@angular/core';
import { EcoleDoctoraleService } from '../../../services/ecole-doctorale.service';
import { EcoleDoctorale } from '../../../models/ecole-doctorale.module';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-ecole-doctorale',
  templateUrl: './ecole-doctorale.component.html',
  styleUrl: './ecole-doctorale.component.css'
})
export class EcoleDoctoraleComponent implements OnInit{
  ecoleDoctorales: EcoleDoctorale[] = [];
  ecoleDoctoraleForm: FormGroup;

  constructor(
    private ecoleDoctoraleService: EcoleDoctoraleService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.ecoleDoctoraleForm = this.formBuilder.group({
      // Define your form controls here based on your Department model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadEcoleDoctorale();
  }

  loadEcoleDoctorale(): void {
    this.ecoleDoctoraleService.getAllEcoleDoctorales().subscribe(data => {
      this.ecoleDoctorales = data;
    });
  }
  editEcoleDoctorale(EcoleDoctoraleId: number): void {
    console.log('EcoleDoctorale ID:', EcoleDoctoraleId);

    if (EcoleDoctoraleId) {
      this.router.navigate(['/ecole-doctorale/edit', EcoleDoctoraleId]);
    }
  }
  deleteEcoleDoctorale(EcoleDoctoraleId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this Ecole Doctorale!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the departmentService to delete the department
        this.ecoleDoctoraleService.deleteEcoleDoctorale(EcoleDoctoraleId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your Ecole Doctorale has been deleted.',
              'success'
            );
            // Refresh the local list of departments after deletion
            this.ecoleDoctorales = this.ecoleDoctorales.filter(department => department.id !== EcoleDoctoraleId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting Ecole Doctorale:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting this Ecole Doctorale.',
              'error'
            );
          }
        );
      }
    });
  }
}
