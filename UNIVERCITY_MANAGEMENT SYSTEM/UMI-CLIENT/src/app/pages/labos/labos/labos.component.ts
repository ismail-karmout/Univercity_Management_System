// labos.component.ts
import { Component, OnInit } from '@angular/core';
import { LaboService } from '../../../services/labo.service';
import { Labo } from '../../../models/labo.module';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';


@Component({
  selector: 'app-labos',
  templateUrl: './labos.component.html',
  styleUrls: ['./labos.component.css']
})
export class LabosComponent implements OnInit {
  labos: Labo[] = [];
  laboForm: FormGroup;

  constructor(
    private laboService: LaboService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.laboForm = this.formBuilder.group({
      // Define your form controls here based on your labo model
      // Example: name: ['', Validators.required],
      // ...
    });
  }

  ngOnInit(): void {
    this.loadLabos();
  }

  loadLabos(): void {
    this.laboService.getAllLabos().subscribe(data => {
      this.labos = data;
    });
  }


  deleteLabo(laboId: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this labo!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the laboService to delete the labo
        this.laboService.deleteLabo(laboId).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your labo has been deleted.',
              'success'
            );
            // Refresh the local list of labos after deletion
            this.labos = this.labos.filter(labo => labo.id !== laboId);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting labo:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the labo.',
              'error'
            );
          }
        );
      }
    });
  }

  editLabo(laboId: number): void {
    console.log('labo ID:', laboId);

    if (laboId) {
      this.router.navigate(['/labos/edit', laboId]);
    }
  }
}
