import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from '../../../services/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class createStudentComponent {
  studentFormGroup!: FormGroup;

  constructor(
    private studentService: StudentService,
    private router: Router,
    private fb: FormBuilder
  ){}

  ngOnInit(): void {
    this.studentFormGroup = this.fb.group({
      firstname: this.fb.control(null, [Validators.required]),
      lastname: this.fb.control(null, [Validators.required]),
      email: this.fb.control(null, [Validators.required]),
      cne: this.fb.control(null, [Validators.required]),
      cni: this.fb.control(null, [Validators.required])

    });
  }

  handleCreateStudent(){
    let student = this.studentFormGroup.value;
    this.studentService.saveStudent(student).subscribe({
      next : data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.studentFormGroup.reset()
      },
      error : err => {
        console.log(err);
      }
    })
  }



  handleCancel(){
    this.router.navigate(['/students']);
  }
}
