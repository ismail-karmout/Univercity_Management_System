import {Component, } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import {Section} from "../../../models/section.module";
import {SectionService} from "../../../services/section.service";
@Component({
  selector: 'app-create-section',
  templateUrl: './create-section.component.html',
  styleUrl: './create-section.component.css'
})
export class CreateSectionComponent{
  newSection: Section = { name: '', description: '', slug: '' };
  constructor(
    private sectionService: SectionService,
    private router: Router
  ) { }
  createSection(): void {
    this.sectionService.createSection(this.newSection).subscribe(() => {
      this.newSection = { name: '', description: '', slug: '' };
      Swal.fire(
        'Create!',
        'Your Section has been created successefully.',
        'success'
      );
      this.router.navigate(['/sections']); // Adjust the route based on your actual route configuration
    });
  }
}
