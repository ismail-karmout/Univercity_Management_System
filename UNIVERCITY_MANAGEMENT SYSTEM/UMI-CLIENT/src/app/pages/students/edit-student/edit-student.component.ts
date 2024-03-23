import { Component } from '@angular/core';
import { Student } from '../../../models/student.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../../../services/student.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrl: './edit-student.component.css'
})
export class EditStudentComponent {
  studentId!: number;
  student!: Student;
  studentFormGroup!: FormGroup;

  constructor(
    private studentService: StudentService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.studentId = this.route.snapshot.params['id'];

    this.studentFormGroup = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      cne: ['', Validators.required],
      cni: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    

    this.studentService.getStudent(this.studentId).subscribe({
      next: data => {
        this.student = data;

        this.studentFormGroup = this.fb.group({
          firstname: this.fb.control(this.student.firstname, [Validators.required]),
          lastname: this.fb.control(this.student.lastname, [Validators.required]),
          email: this.fb.control(this.student.email, [Validators.required]),
          cne: this.fb.control(this.student.cne, [Validators.required]),
          cni: this.fb.control(this.student.cni, [Validators.required]),
        }); 

      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleEditStudent(){
    let s = this.studentFormGroup.value;
    s.id = this.studentId;

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

        this.studentService.updateStudent(s).subscribe({
          next : data => {

            this.router.navigate(['/students']);
            this.studentFormGroup.reset()
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
    this.router.navigate(['/students']);
  }
}
