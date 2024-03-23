import { Component, OnInit } from '@angular/core';
import { EcoleDoctoraleService } from '../../../services/ecole-doctorale.service';
import { EcoleDoctorale } from '../../../models/ecole-doctorale.module';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-edit-ecole-doctorale',
  templateUrl: './edit-ecole-doctorale.component.html',
  styleUrl: './edit-ecole-doctorale.component.css'
})
export class EditEcoleDoctoraleComponent implements OnInit{
  selectedEcoleDoctorale: EcoleDoctorale = { id: 0, name: '', description: '', slug: '',created_at:'',updated_at:'',deleted_at:''}
  constructor(
    private ecoleDoctoraleService: EcoleDoctoraleService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Fetch the Department ID from the route parameters
    const EcoleDoctoraleId = this.route.snapshot.params['id'];
    // Call the service to get the selected Department
    this.ecoleDoctoraleService.getEcoleDoctoraleById(EcoleDoctoraleId).subscribe(
      (ecoleDoctorale: EcoleDoctorale) => {
        this.selectedEcoleDoctorale = ecoleDoctorale;
      },
      (error) => {
        console.error('Error fetching Ecole Doctorale:', error);
      }
    );
  }
  updateEcoleDoctorale(): void {
        // Call the service to update the EcoleDoctorale
        this.ecoleDoctoraleService.updateEcoleDoctorale(this.selectedEcoleDoctorale.id!, this.selectedEcoleDoctorale).subscribe(
            () => {
                Swal.fire(
                    'Udpate!',
                    'Your Ecole-Doctorale has been updated successefully.',
                    'success'
                );
                // Redirect to the Departments list or navigate to the desired page
                this.router.navigate(['/ecole-doctorale']);
            },
            (error) => {
                console.error('Error updating Ecole-doctorale:', error);
            }
        );
    }
}
