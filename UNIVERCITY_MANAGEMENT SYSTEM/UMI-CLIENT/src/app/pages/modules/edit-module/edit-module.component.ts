import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Module } from '../../../models/module.model';
import { ModuleService } from '../../../services/module.service';
import { ModuleElementService } from '../../../services/module-element.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-edit-module',
  templateUrl: './edit-module.component.html',
  styleUrl: './edit-module.component.css'
})
export class EditModuleComponent implements OnInit {
  moduleId!: number;
  module!: Module;
  moduleFormGroup!: FormGroup;

  constructor(
    private moduleService: ModuleService,
    private moduleElementService: ModuleElementService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.moduleId = this.route.snapshot.params['id'];

    this.moduleFormGroup = this.fb.group({
      name: ['', Validators.required],
      slug: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    

    this.moduleService.getModule(this.moduleId).subscribe({
      next: data => {
        this.module = data;

        this.moduleFormGroup = this.fb.group({
          name: this.fb.control(this.module.name, [Validators.required]),
          slug: this.fb.control(this.module.slug, [Validators.required])

        }); 

      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleEditModule(){
    let m = this.moduleFormGroup.value;
    m.id = this.moduleId;

    Swal.fire({
      title: 'Do you want to save the changes?',
      //showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        Swal.fire('Saved!', '', 'success')

        this.moduleService.updateModule(m).subscribe({
          next : data => {

            this.router.navigate(['/modules']);
            this.moduleFormGroup.reset()
          },
          error : err => {
            console.log(err);
          }
        })

      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })
  }


  handleAddModuleElement(module: Module){
    this.router.navigateByUrl("moduleElement/add/"+module.id);
  }

  handleCancel() {
    this.router.navigate(['/module']);
  }
}
