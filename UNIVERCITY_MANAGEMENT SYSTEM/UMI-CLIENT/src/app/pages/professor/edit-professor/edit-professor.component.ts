import { Component } from '@angular/core';
import { Professor } from '../../../models/professor.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProfessorService } from '../../../services/professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-professor',
  templateUrl: './edit-professor.component.html',
  styleUrl: './edit-professor.component.css'
})
export class EditProfessorComponent {
  professorId!: number;
  professor!: Professor;
  professorFormGroup!: FormGroup;

  constructor(
    private professorService: ProfessorService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.professorId = this.route.snapshot.params['id'];

    this.professorFormGroup = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    

    this.professorService.getProfessor(this.professorId).subscribe({
      next: data => {
        this.professor = data;

        this.professorFormGroup = this.fb.group({
          firstname: this.fb.control(this.professor.firstname, [Validators.required]),
          lastname: this.fb.control(this.professor.lastname, [Validators.required]),
          email: this.fb.control(this.professor.email, [Validators.required]),
          phone: this.fb.control(this.professor.phone, [Validators.required]),
        }); 

      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleEditProfessor(){
    let p = this.professorFormGroup.value;
    p.id = this.professorId;

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

        this.professorService.updateProfessor(p).subscribe({
          next : data => {

            this.router.navigate(['/professors']);
            this.professorFormGroup.reset()
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



  handleCancel() {
    this.router.navigate(['/professors']);
  }
}
