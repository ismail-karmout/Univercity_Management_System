import { Component } from '@angular/core';
import { Eventr } from '../../../models/eventr.module';
import { EventrService } from '../../../services/eventr.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-get-all-eventr',
  templateUrl: './get-all-eventr.component.html',
  styleUrl: './get-all-eventr.component.css'
})
export class GetAllEventrComponent {

  eventr: Eventr[] = [];

  constructor(
    private eventrService: EventrService,
    private router: Router
) { }

  ngOnInit(): void {
    // this.loadDepartments();
    this.loadEventr();
}
loadEventr(): void {
  this.eventrService.getAllEventr().subscribe(Eventr => {
      this.eventr = Eventr;
  });
}

editEventr(EventrId: number): void {
  console.log('Event-Recherche ID:', EventrId);

  if (EventrId) {
    this.router.navigate(['/eventr/edit', EventrId]);
  }
}

deleteEventr(EventrId: number): void {
  // Show a confirmation dialog using SweetAlert
  Swal.fire({
    title: 'Are you sure?',
    text: 'You will not be able to recover this Event-Recherche!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Yes, delete it!',
    cancelButtonText: 'No, keep it'
  }).then((result) => {
    // If the user confirms deletion
    if (result.isConfirmed) {
      // Make a call to the departmentService to delete the department
      this.eventrService.deleteEventr(EventrId).subscribe(
        () => {
          // On successful deletion, show a success message with SweetAlert
          Swal.fire(
            'Deleted!',
            'Your Event-Recherche has been deleted.',
            'success'
          );
          // Refresh the local list of departments after deletion
          this.eventr = this.eventr.filter(eventr => eventr.id !== EventrId);
        },
        // If an error occurs during deletion, show an error message with SweetAlert
        error => {
          console.error('Error deleting news:', error);
          Swal.fire(
            'Error!',
            'An error occurred while deleting the news.',
            'error'
          );
        }
      );
    }
  });
}

}
