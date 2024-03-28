import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Module } from '../../../models/module.model';
import { ModuleService } from '../../../services/module.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-modules',
  templateUrl: './modules.component.html',
  styleUrl: './modules.component.css'
})
export class ModulesComponent implements OnInit{
  modules!: Module[];


  constructor(
    private moduleService: ModuleService,
    private router: Router
  ){}

  ngOnInit(): void{
    this.getAllModules();
  }

  getAllModules(): void {
    this.moduleService.getAllModules().subscribe(
      data => {
        this.modules = data;
      }
    );
  }
  

  handleDeleteModule(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this module!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.moduleService.deleteModule(id).subscribe({
          next: (data) => {
            Swal.fire(
              'Deleted!',
              'Your module has been deleted.',
              'success'
            );
            // Refresh the modules list after deletion
                    this.ngOnInit();

          },
          error: (err) => {
            Swal.fire(
              'Error!',
              'An error occurred while deleting the module.',
              'error'
            );
          }
        });
      }
    });
  }

  handleEditModule(module: Module){
    this.router.navigateByUrl("modules/edit/"+module.id);
  }


  // reloadStudents() {
  //   console.log("Current route I am on:",this.router.url);

  //   this.router.navigateByUrl('/', { skipLocationChange:true }).then(() => {
  //     this.router.navigate(['/modules']).then(()=>{
  //       console.log(`After navigation I am on:${this.router.url}`);
  //     })
  //   });
  // }


}
