// recherche-axe.component.ts
import { Component, OnInit } from '@angular/core';
import { RechercheAxeSercice } from '../../../services/recherche-axe.service';
import { RechercheAxe } from '../../../models/recherche-axe.module';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-recherche-axes',
  templateUrl: './recherche-axes.component.html',
  styleUrls: ['./recherche-axes.component.css']
})
export class RechercheAxesComponent implements OnInit {
  rechercheAxes: RechercheAxe[] = [];
  rechercheAxeForm: FormGroup;

  constructor(
    private rechercheAxeSercice: RechercheAxeSercice,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.rechercheAxeForm = this.formBuilder.group({
      // Define your form controls here based on your rechercheAxe model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadrechercheAxes();
  }

  loadrechercheAxes(): void {
    this.rechercheAxeSercice.getAllRechercheAxes().subscribe(data => {
      this.rechercheAxes = data;
    });
  }

  deleteRechercheAxe(rechercheAxeId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this recherche axe!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the etablissemtnService to delete the recherche axe
        this.rechercheAxeSercice.deleteRechercheAxe(rechercheAxeId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your recherche recherche axe has been deleted.',
              'success'
            );
            // Refresh the local list of recherche axes after deletion
            this.rechercheAxes = this.rechercheAxes.filter(rechercheAxe => rechercheAxe.id !== rechercheAxeId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting recherche axe:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the recherche axe.',
              'error'
            );
          }
        );
      }
    });
  }



  // deleteRechercheAxe(rechercheAxeId: number): void {
  //   const confirmDelete = confirm('Are you sure you want to delete this RechercheAxe?');
  //   if (confirmDelete) {
  //     this.rechercheAxeSercice.deleteRechercheAxe(rechercheAxeId);
  //     this.rechercheAxes = this.rechercheAxes.filter(etab => etab.id !== rechercheAxeId);

  //   }
  // }

  editRechercheAxe(rechercheAxeId: number): void {
    console.log('RechercheAxe ID:', rechercheAxeId);

    if (rechercheAxeId) {
      this.router.navigate(['/recherche-axe/edit', rechercheAxeId]);
    }
  }
}
