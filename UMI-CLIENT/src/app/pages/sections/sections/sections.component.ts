import {Component, OnInit} from '@angular/core';
import { SectionService } from '../../../services/section.service';
import { Section } from '../../../models/section.module';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrl: './sections.component.css'
})
export class SectionsComponent implements OnInit{
  sections: Section[] = [];
  constructor(
    private sectionService: SectionService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.loadSections();
  }
  viewPdfFile(SectionID:any):void{

    if(SectionID){
      this.router.navigate(
        ['/pdfView'],
        { queryParams: { id: ''+SectionID } }
      );
    }
  }
  loadSections(): void {
    this.sectionService.getAllSections().subscribe(data => {
      this.sections = data;
    });
  }
  editSection(SectionID: number): void {
    console.log('Section ID:', SectionID);

    if (SectionID) {
      this.router.navigate(['/sections/edit', SectionID]);
    }
  }
  deleteSection(SectionID: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this Section!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the departmentService to delete the department
        this.sectionService.deleteSection(SectionID).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your Section has been deleted.',
              'success'
            );
            // Refresh the local list of departments after deletion
            this.sections = this.sections.filter(section => section.id !== SectionID);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting Section:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting this Section.',
              'error'
            );
          }
        );
      }
    });
  }
}
