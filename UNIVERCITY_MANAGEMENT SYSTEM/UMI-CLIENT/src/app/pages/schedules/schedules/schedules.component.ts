import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import Swal from "sweetalert2";
import {Schedule} from "../../../models/schedule.module";
import {ScheduleService} from "../../../services/schedule.service";
@Component({
  selector: 'app-schedules',
  templateUrl: './schedules.component.html',
  styleUrl: './schedules.component.css'
})
export class SchedulesComponent implements OnInit{
  schedules: Schedule[] = [];
  //pdfSource:string="/Users/youssefsaklab/Documents/Files/avis.pdf";
  //<a href="#" (click)="openPdfInPopup(' ../../Files/'+schedule.schedule)">View Schedule</a>
  //selectedSchedule:Schedule={id:0,name:'',schedule:'',section:{id:0,name:'',description:'',slug:''}};
  constructor(
    private scheduleService: ScheduleService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.loadSchedule();
  }
  loadSchedule(): void {
    this.scheduleService.getAllSchedules().subscribe(data => {
      this.schedules = data;
    });
  }
  editSchedule(ScheduleID: number): void {
    if (ScheduleID) {
      this.router.navigate(['/schedules/edit', ScheduleID]);
    }
  }
  showSectionInfo(ScheduleObj:Schedule):void{
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Section Info',
      html: "Name: "+ScheduleObj.section?.name+"</br>Description: "
        +ScheduleObj.section?.description,
      icon: 'info',
    });
  }
  viewPdfFile(SectionID:any):void{

    if(SectionID){
      this.router.navigate(
        ['/pdfView'],
        { queryParams: { id: ''+SectionID } }
      );
    }
  }
  deleteSchedule(ScheduleID: number): void {
    // Show a confirmation dialog using SweetAlert
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this Schedule!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      // If the user confirms deletion
      if (result.isConfirmed) {
        // Make a call to the departmentService to delete the department
        this.scheduleService.deleteSchedule(ScheduleID).subscribe(
          () => {
            // On successful deletion, show a success message with SweetAlert
            Swal.fire(
              'Deleted!',
              'Your Schedule has been deleted.',
              'success'
            );
            // Refresh the local list of departments after deletion
            this.schedules = this.schedules.filter(schedule => schedule.id !== ScheduleID);
          },
          // If an error occurs during deletion, show an error message with SweetAlert
          error => {
            console.error('Error deleting Schedule:', error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting this Schedule.',
              'error'
            );
          }
        );
      }
    });
  }
}
