import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Eventr } from '../../../models/eventr.module';
import { ActivatedRoute, Router } from '@angular/router';
import { EventrService } from '../../../services/eventr.service';
import { LaboService } from '../../../services/labo.service';
import { Labo } from '../../../models/labo.module';

@Component({
  selector: 'app-update-eventr',
  templateUrl: './update-eventr.component.html',
  styleUrl: './update-eventr.component.css'
})
export class UpdateEventrComponent {

  selectedEventr: Eventr = { id: 0, intitule: '', justificatif: '',lieu: '', date: '', description: '',type: '' , image: '', eventrImages: [] };
  labs: Labo[] = [];

    constructor(
        private EventrService: EventrService,
        private labsService: LaboService,
        private route: ActivatedRoute,
        private router: Router,
       
    ) { }

    loadLabs(): void {
        this.labsService.getAllLabos().subscribe(labss => {
            this.labs = labss;
        });
      }

    ngOnInit(): void {

        this.loadLabs();
        // Fetch the Department ID from the route parameters
        const EventrId = this.route.snapshot.params['id'];

        // Call the service to get the selected Department
        this.EventrService.getEventrById(EventrId).subscribe(
            (Eventr: Eventr) => {
                this.selectedEventr = Eventr;
            },
            (error) => {
                console.error('Error fetching Eventr:', error);
            }
        );
         
    }

   
   
    updateEventr(): void {
        // Call the service to update the Department
        this.EventrService.updateEventr(this.selectedEventr.id!, this.selectedEventr).subscribe(
            () => {
                Swal.fire(
                    'Udpate!',
                    'Your Eventr has been updated successefully.',
                    'success'
                );
                // Redirect to the Departments list or navigate to the desired page
                this.router.navigate(['/eventr/get']);
            },
            (error) => {
                console.error('Error updating news:', error);
            }
        );
    }


}
