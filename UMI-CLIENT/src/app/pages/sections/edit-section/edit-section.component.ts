import {Component, OnInit} from '@angular/core';
import {Section} from "../../../models/section.module";
import {ActivatedRoute, Router} from "@angular/router";
import {SectionService} from "../../../services/section.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-edit-section',
  templateUrl: './edit-section.component.html',
  styleUrl: './edit-section.component.css'
})
export class EditSectionComponent implements OnInit{
  selectedSection: Section = { id: 0, name: '', description: '', slug: ''}
  constructor(
    private sectionService: SectionService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    // Fetch the Department ID from the route parameters
    const SectionId = this.route.snapshot.params['id'];
    // Call the service to get the selected Department
    this.sectionService.getSectionById(SectionId).subscribe(
      (section: Section) => {
        this.selectedSection = section;
      },
      (error) => {
        console.error('Error fetching Section:', error);
      }
    );
  }
  updateSection(): void {
    // Call the service to update the Section
    this.sectionService.updateSection(this.selectedSection.id!, this.selectedSection).subscribe(
      () => {
        Swal.fire(
          'Udpate!',
          'Your Section has been updated successefully.',
          'success'
        );
        // Redirect to the Departments list or navigate to the desired page
        this.router.navigate(['/sections']);
      },
      (error) => {
        console.error('Error updating Section:', error);
      }
    );
  }
}
