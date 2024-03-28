import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PhdStudentService } from '../../../services/phdStudent.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-phd-student',
  templateUrl: './create-phd-student.component.html',
  styleUrl: './create-phd-student.component.css'
})
export class CreatePhdStudentComponent {
  phdStudentFormGroup!: FormGroup;

  constructor(
    private phdStudentService: PhdStudentService,
    private router: Router,
    private fb: FormBuilder
  ){}

  ngOnInit(): void {
    this.phdStudentFormGroup = this.fb.group({
      firstname: this.fb.control(null, [Validators.required]),
      lastname: this.fb.control(null, [Validators.required]),
      email: this.fb.control(null, [Validators.required]),
      phone: this.fb.control(null, [Validators.required]),
    });
  }

  handleCreatePhdStudent(){
    let phdStudent = this.phdStudentFormGroup.value;
    this.phdStudentService.savePhdStudent(phdStudent).subscribe({
      next : data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.phdStudentFormGroup.reset()
      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleCancel(){
    this.router.navigate(['/phdStudents']);
  }

}
