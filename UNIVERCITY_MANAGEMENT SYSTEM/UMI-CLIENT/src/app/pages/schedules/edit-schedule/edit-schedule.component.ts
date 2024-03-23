import {Component, OnInit} from '@angular/core';
import {Schedule} from "../../../models/schedule.module";
import {Section} from "../../../models/section.module";
import {ActivatedRoute, Router} from "@angular/router";
import {ScheduleService} from "../../../services/schedule.service";
import Swal from "sweetalert2";
import {SectionService} from "../../../services/section.service";

@Component({
  selector: 'app-edit-schedule',
  templateUrl: './edit-schedule.component.html',
  styleUrl: './edit-schedule.component.css'
})
export class EditScheduleComponent implements OnInit{
  schedules: Schedule[] = [];
  sections:Section[]=[];
  selectedSchedule:Schedule={name:'',schedule:'',created_at:'',section:{id:0,name:'',description:'',slug:''}};
  //newSchedule:any;
  thisFile:any
  constructor(
    private scheduleService: ScheduleService,
    private sectionService:SectionService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Fetch the Department ID from the route parameters
    const ScheduleId = this.route.snapshot.params['id'];
    this.loadSections();
    // Call the service to get the selected Department
    this.scheduleService.getScheduleById(ScheduleId).subscribe(
      (schedule: Schedule) => {
        this.selectedSchedule = schedule;
      },
      (error) => {
        console.error('Error fetching Schedule:', error);
      }
    );
  }
  loadSections(): void {
    this.sectionService.getAllSections().subscribe(data => {
      this.sections = data;
    });
  }
  updateSchedule(): void {
    const fd = new FormData();
    fd.append('name',this.selectedSchedule.name);
    fd.append('created_at',this.selectedSchedule.created_at+"");
    fd.append('section.id',this.selectedSchedule.section.id+"");
    fd.append('section.name',this.selectedSchedule.section.name);
    fd.append('section.description',this.selectedSchedule.section.description);
    fd.append('section.slug',this.selectedSchedule.section.slug);
    fd.append('file', this.thisFile);
    // Call the service to update the Section
    this.scheduleService.updateSchedule(this.selectedSchedule.id!, fd).subscribe(
      () => {
        this.selectedSchedule = {name:'',schedule:'',created_at:'',section:{id:0,name:'',description:'',slug:''}};
        Swal.fire(
          'Update!',
          'Your Schedule has been updated successfully.',
          'success'
        );
        // Redirect to the Departments list or navigate to the desired page
        this.router.navigate(['/schedules']);
      },
      (error) => {
        console.error('Error updating Schedule:', error);
      }
    );
  }

  changeFile(event:any){
    const inputElement = event.target as HTMLInputElement;
    if (inputElement.files && inputElement.files.length > 0)
      this.thisFile = inputElement.files[0];
    console.log(this.thisFile)
  }
}
