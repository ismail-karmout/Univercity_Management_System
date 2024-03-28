import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModuleService } from '../../../services/module.service';
import Swal from 'sweetalert2';
import { ProfessorService } from '../../../services/professor.service';
import { SemestresService } from '../../../services/semestres.service';
import { Semestre } from '../../../models/semestre.module';
import { Professor } from '../../../models/professor.model';
import { TypeSession } from '../../../models/typeSession';
import { Session } from '../../../models/session';


@Component({
  selector: 'app-create-module',
  templateUrl: './create-module.component.html',
  styleUrl: './create-module.component.css'
})
export class CreateModuleComponent implements OnInit{
  moduleFormGroup!: FormGroup;
  semestres!: Semestre[];
  professors!: Professor[];
  typeSessionsEnum = TypeSession;
  sessionsEnum = Session;
  filteredSemestres: Semestre[] = []; // Add a new property for the filtered semestres

  
  

  constructor(
    private moduleService: ModuleService,
    private professorService: ProfessorService,
    private semestreService: SemestresService,
    private router: Router,
    private fb: FormBuilder,
    // private filterSemestrePipe: FilterSemestrePipe // Inject the pipe

  ){}

  ngOnInit(): void {
    this.moduleFormGroup = this.fb.group({
      name: this.fb.control(null),
      slug: this.fb.control(null),
      selectedSession: this.fb.control(null),
      selectedTypeSession: this.fb.control(null),
      // semestreId: this.fb.control(null),
      // professorId: this.fb.control(null)

    });

    // this.moduleFormGroup.get('selectedSession')?.valueChanges.subscribe(session => {
    //   this.filterSemestres();
    // });
    // this.moduleFormGroup.get('selectedTypeSession')?.valueChanges.subscribe(typeSession => {
    //   this.filterSemestres();
    // });


    this.professorService.getAllProfessors().subscribe(
      data => {
        this.professors = data;
      }
    );

    this.semestreService.getAllSemestres().subscribe(
      data => {
        this.semestres = data;
      }
    );
  }

  //   filterSemestres() {
  //   const selectedSession = this.moduleFormGroup.get('selectedSession')?.value;
  //   const selectedTypeSession = this.moduleFormGroup.get('selectedTypeSession')?.value;
  //   this.filteredSemestres = this.filterSemestrePipe.transform(this.semestres, selectedSession, selectedTypeSession);
  // }

  getEnumKeys(enumObj: any) {
    return Object.keys(enumObj)
    .filter(key => isNaN(Number(enumObj[key])))
    .map(key => ({ key, value: enumObj[key] }));  
  }

  handleCreateModule(){
    // this.moduleFormGroup.removeControl('selectedSession');
    // this.moduleFormGroup.removeControl('electedTypeSession');

    let module = this.moduleFormGroup.value;


    console.log(module)
    this.moduleService.saveModule(module).subscribe({
      next : data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.moduleFormGroup.reset()
      },
      error : err => {
        console.log(err);
      }
    })
  }



  handleCancel(){
    this.router.navigate(['/modules']);
  }

}
