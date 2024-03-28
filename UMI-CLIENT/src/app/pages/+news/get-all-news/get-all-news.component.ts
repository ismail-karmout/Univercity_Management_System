import { Component } from '@angular/core';
import { News } from '../../../models/news.module';
import { NewsService } from '../../../services/news.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-get-all-news',
  templateUrl: './get-all-news.component.html',
  styleUrl: './get-all-news.component.css'
})
export class GetAllNewsComponent {
  news: News[] = [];

  constructor(
    private newService: NewsService,
    private router: Router
) { }

  ngOnInit(): void {
    // this.loadDepartments();
    this.loadNews();
}
loadNews(): void {
  this.newService.getAllNews().subscribe(News => {
      this.news = News;
  });
}

editNews(NewsId: number): void {
  console.log('News ID:', NewsId);

  if (NewsId) {
    this.router.navigate(['/news/edit', NewsId]);
  }
}

// deleteNews(id: number): void {
//   this.newService.deleteNews(id).subscribe(() => {
//       this.loadNews();
//   });
// }

deleteNews(NewsId: number): void {
  // Show a confirmation dialog using SweetAlert
  Swal.fire({
    title: 'Are you sure?',
    text: 'You will not be able to recover this news!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Yes, delete it!',
    cancelButtonText: 'No, keep it'
  }).then((result) => {
    // If the user confirms deletion
    if (result.isConfirmed) {
      // Make a call to the departmentService to delete the department
      this.newService.deleteNews(NewsId).subscribe(
        () => {
          // On successful deletion, show a success message with SweetAlert
          Swal.fire(
            'Deleted!',
            'Your News has been deleted.',
            'success'
          );
          // Refresh the local list of departments after deletion
          this.news = this.news.filter(department => department.id !== NewsId);
        },
        // If an error occurs during deletion, show an error message with SweetAlert
        error => {
          console.error('Error deleting news:', error);
          Swal.fire(
            'Error!',
            'An error occurred while deleting the news.',
            'error'
          );
        }
      );
    }
  });
}

}
