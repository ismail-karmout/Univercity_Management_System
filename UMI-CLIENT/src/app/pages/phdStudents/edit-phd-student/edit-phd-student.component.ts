import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PhdStudent } from '../../../models/phdStudent.model';
import { PhdStudentService } from '../../../services/phdStudent.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-phd-student',
  templateUrl: './edit-phd-student.component.html',
  styleUrl: './edit-phd-student.component.css'
})
export class EditPhdStudentComponent {
  phdStudentId!: number;
  phdStudent!: PhdStudent;
  phdStudentFormGroup!: FormGroup;

  constructor(
    private phdStudentService: PhdStudentService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.phdStudentId = this.route.snapshot.params['id'];

    this.phdStudentFormGroup = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    

    this.phdStudentService.getPhdStudent(this.phdStudentId).subscribe({
      next: data => {
        this.phdStudent = data;

        this.phdStudentFormGroup = this.fb.group({
          firstname: this.fb.control(this.phdStudent.firstname, [Validators.required]),
          lastname: this.fb.control(this.phdStudent.lastname, [Validators.required]),
          email: this.fb.control(this.phdStudent.email, [Validators.required]),
          phone: this.fb.control(this.phdStudent.phone, [Validators.required]),
        }); 

      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleEditPhdStudent(){
    let p = this.phdStudentFormGroup.value;
    p.id = this.phdStudentId;

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

        this.phdStudentService.updatePhdStudent(p).subscribe({
          next : data => {

            this.router.navigate(['/phdStudents']);
            this.phdStudentFormGroup.reset()
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
    this.router.navigate(['/phdStudents']);
  }
}
