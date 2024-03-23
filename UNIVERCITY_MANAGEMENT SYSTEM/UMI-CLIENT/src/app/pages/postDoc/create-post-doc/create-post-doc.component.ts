import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PostDocService } from '../../../services/postDoc.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-post-doc',
  templateUrl: './create-post-doc.component.html',
  styleUrl: './create-post-doc.component.css'
})
export class CreatePostDocComponent {
  postDocFormGroup!: FormGroup;

  constructor(
    private postDocService: PostDocService,
    private router: Router,
    private fb: FormBuilder
  ){}

  ngOnInit(): void {
    this.postDocFormGroup = this.fb.group({
      firstname: this.fb.control(null, [Validators.required]),
      lastname: this.fb.control(null, [Validators.required]),
      email: this.fb.control(null, [Validators.required]),
      phone: this.fb.control(null, [Validators.required]),
    });
  }

  handleCreatePostDoc(){
    let postDoc = this.postDocFormGroup.value;
    this.postDocService.savePostDoc(postDoc).subscribe({
      next : data => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
        this.postDocFormGroup.reset()
      },
      error : err => {
        console.log(err);
      }
    })
  }


  handleCancel(){
    this.router.navigate(['/postDocs']);
  }
}
