import {Component, OnInit} from '@angular/core';
import {Schedule} from "../../../models/schedule.module";
import {Section} from "../../../models/section.module";
import {ScheduleService} from "../../../services/schedule.service";
import {Event, Router} from "@angular/router";
import {SectionService} from "../../../services/section.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-create-schedule',
  templateUrl: './create-schedule.component.html',
  styleUrl: './create-schedule.component.css'
})
export class CreateScheduleComponent implements OnInit{
  schedules: Schedule[] = [];
  sections:Section[]=[];
  newSchedule:Schedule={name:'',schedule:'',section:{id:0,name:'',description:'',slug:''}};
  //newSchedule:any;
  thisFile:any
  constructor(
    private scheduleService: ScheduleService,
    private sectionService:SectionService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.loadSections();
  }
  loadSections(): void {
    this.sectionService.getAllSections().subscribe(data => {
      this.sections = data;
    });
  }
  loadSchedule(): void {
    this.scheduleService.getAllSchedules().subscribe(data => {
      this.schedules = data;
    });
  }
  createSchedule(): void {
    console.log(this.thisFile)
    const fd = new FormData();
    fd.append('name',this.newSchedule.name);
    fd.append('section.id',this.newSchedule.section.id+"");
    fd.append('section.name',this.newSchedule.section.name);
    fd.append('section.description',this.newSchedule.section.description);
    fd.append('section.slug',this.newSchedule.section.slug);
    fd.append('file', this.thisFile);
    this.scheduleService.createSchedule(fd).subscribe(() => {
      //this.loadSchedule();
      this.newSchedule = {name:'',schedule:'',section:{id:0,name:'',description:'',slug:''}};
      Swal.fire(
        'Create!',
        'Your Schedule has been created successfully.',
        'success'
      );
      this.router.navigate(['/schedules']); // Adjust the route based on your actual route configuration
    });
  }
  changeFile(event:any){
    const inputElement = event.target as HTMLInputElement;
    if (inputElement.files && inputElement.files.length > 0)
      this.thisFile = inputElement.files[0];
    console.log(this.thisFile)
  }
}
