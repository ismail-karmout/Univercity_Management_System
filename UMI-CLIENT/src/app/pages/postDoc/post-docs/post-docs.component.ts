import { Component } from '@angular/core';
import { PostDoc } from '../../../models/postDoc.model';
import { PostDocService } from '../../../services/postDoc.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-post-docs',
  templateUrl: './post-docs.component.html',
  styleUrl: './post-docs.component.css'
})
export class PostDocsComponent {
  postDocs!: PostDoc[];

  constructor(
    private postDocService: PostDocService,
    private router: Router
  ){}

  ngOnInit(): void{
    this.getAllPostDocs();
  }

  getAllPostDocs(): void{
    this.postDocService.getAllPostDocs().subscribe(
      data => this.postDocs = data
    );
  }

  handleDeletePostDoc(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this module!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this.postDocService.deletePostDoc(id).subscribe({
          next: (data) => {
            Swal.fire(
              'Deleted!',
              'Your module has been deleted.',
              'success'
            );
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

  handleEditPostDoc(postDoc: PostDoc){
    this.router.navigateByUrl("postDocs/edit/"+postDoc.id);
  }

}
