import {Component, OnInit} from '@angular/core';
import {Groupe} from "../../../models/groupes.module";
import {Section} from "../../../models/section.module";
import {GroupesService} from "../../../services/groupes.service";
import {SectionService} from "../../../services/section.service";
import {ActivatedRoute, Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-edit-groupe',
  templateUrl: './edit-groupe.component.html',
  styleUrl: './edit-groupe.component.css'
})
export class EditGroupeComponent implements OnInit{
  selectedGroup: Groupe = { name: '', description: '', slug: '',section:{id:0,name:'',description:'',slug:''} };
  sections:Section[]=[];
  constructor(
    private groupesService: GroupesService,
    private sectionService:SectionService,
    private route: ActivatedRoute,
    private router: Router
  ) { }
  ngOnInit(): void {
    const GroupID = this.route.snapshot.params['id'];
    this.loadSections();
    // Call the service to get the selected Department
    this.groupesService.getGroupById(GroupID).subscribe(
      (groupe: Groupe) => {
        this.selectedGroup = groupe;
      },
      (error) => {
        console.error('Error fetching Group:', error);
      }
    );
  }
  loadSections(): void {
    this.sectionService.getAllSections().subscribe(data => {
      this.sections = data;
    });
  }
  updateGroup(): void {
    // Call the service to update the Section
    this.groupesService.updateGroup(this.selectedGroup.id!, this.selectedGroup).subscribe(
      () => {
        Swal.fire(
          'Update!',
          'Your Group has been updated successfully.',
          'success'
        );
        // Redirect to the Departments list or navigate to the desired page
        this.router.navigate(['/groups']);
      },
      (error) => {
        console.error('Error updating Group:', error);
      }
    );
  }
}
