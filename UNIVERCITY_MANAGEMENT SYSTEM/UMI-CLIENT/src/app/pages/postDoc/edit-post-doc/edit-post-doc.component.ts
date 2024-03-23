import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { PostDoc } from '../../../models/postDoc.model';
import { PostDocService } from '../../../services/postDoc.service';

@Component({
  selector: 'app-edit-post-doc',
  templateUrl: './edit-post-doc.component.html',
  styleUrl: './edit-post-doc.component.css'
})
export class EditPostDocComponent {
  postDocId!: number;
  postDoc!: PostDoc;
  postDocFormGroup!: FormGroup;

  constructor(
    private postDocService: PostDocService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.postDocId = this.route.snapshot.params['id'];

    this.postDocFormGroup = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    

    this.postDocService.getPostDoc(this.postDocId).subscribe({
      next: data => {
        this.postDoc = data;

        this.postDocFormGroup = this.fb.group({
          firstname: this.fb.control(this.postDoc.firstname, [Validators.required]),
          lastname: this.fb.control(this.postDoc.lastname, [Validators.required]),
          email: this.fb.control(this.postDoc.email, [Validators.required]),
          phone: this.fb.control(this.postDoc.phone, [Validators.required]),
        }); 

      },
      error : err => {
        console.log(err);
      }
    })
  }

  handleEditPostDoc(){
    let p = this.postDocFormGroup.value;
    p.id = this.postDocId;

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

        this.postDocService.updatePostDoc(p).subscribe({
          next : data => {

            this.router.navigate(['/postDocs']);
            this.postDocFormGroup.reset()
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
    this.router.navigate(['/postDocs']);
  }
}
