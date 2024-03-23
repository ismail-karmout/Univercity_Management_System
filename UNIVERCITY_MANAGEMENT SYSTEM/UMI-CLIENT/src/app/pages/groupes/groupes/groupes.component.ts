import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Groupe} from "../../../models/groupes.module";
import {GroupesService} from "../../../services/groupes.service";
import Swal from "sweetalert2";
import {Schedule} from "../../../models/schedule.module";

@Component({
  selector: 'app-groupes',
  templateUrl: './groupes.component.html',
  styleUrl: './groupes.component.css'
})
export class GroupesComponent implements OnInit{
  groupes: Groupe[] = [];
  constructor(
    private groupesService: GroupesService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.loadGroups();
  }
  viewPdfFile(SectionID:any):void{

    if(SectionID){
      this.router.navigate(
        ['/pdfView'],
        { queryParams: { id: ''+SectionID } }
      );
    }
  }
  loadGroups(): void {
    this.groupesService.getAllGroups().subscribe(data => {
      this.groupes = data;
    });
  }
  showSectionInfo(GroupeObj:Groupe):void{
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Section Info',
      html: "Name: "+GroupeObj.section?.name+"</br>Description: "
        +GroupeObj.section?.description,
      icon: 'info',
    });
  }
  editGroup(GroupID: number): void {
    if (GroupID) {
      this.router.navigate(['/groups/edit', GroupID]);
    }
  }
  deleteGroup(GroupID: number): void {
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
        this.groupesService.deleteGroup(GroupID).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your Group has been deleted.',
              'success'
            );
            // Refresh the local list of departments after deletion
            this.groupes = this.groupes.filter(group => group.id !== GroupID);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting Group:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting this Group.',
              'error'
            );
          }
        );
      }
    });
  }
}
