import {Component, OnInit} from '@angular/core';
import Swal from "sweetalert2";
import {SectionService} from "../../../services/section.service";
import {Router} from "@angular/router";
import {Groupe} from "../../../models/groupes.module";
import {GroupesService} from "../../../services/groupes.service";
import {Section} from "../../../models/section.module";

@Component({
  selector: 'app-create-groupe',
  templateUrl: './create-groupe.component.html',
  styleUrl: './create-groupe.component.css'
})
export class CreateGroupeComponent implements OnInit{
  newGroup: Groupe = { name: '', description: '', slug: '',section:{id:0,name:'',description:'',slug:''} };
  sections:Section[]=[];
  constructor(
    private groupesService: GroupesService,
    private sectionService:SectionService,
    private router: Router
  ) { }
  ngOnInit(): void {
    this.loadSections();
  }
  loadSections(): void {
    this.sectionService.getAllSections().subscribe(data => {
      this.sections = data;
    });
  }
  createGroup(): void {
    this.groupesService.createGroup(this.newGroup).subscribe(() => {
      this.newGroup = { name: '', description: '', slug: '',section:{id:0,name:'',description:'',slug:''} };
      Swal.fire(
        'Create!',
        'Your Group has been created successfully.',
        'success'
      );
      this.router.navigate(['/groups']); // Adjust the route based on your actual route configuration
    });
  }
}
