import { Component } from '@angular/core';
import { News } from '../../../models/news.module';
import { NewsService } from '../../../services/news.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-news',
  templateUrl: './update-news.component.html',
  styleUrl: './update-news.component.css'
})
export class UpdateNewsComponent {

  selectedNews: News = { id: 0, title: '',   description: '', type: '' , date: '', department_id:{id: 0} , newsImages:[] };
    

    constructor(
        private NewsService: NewsService,
        private route: ActivatedRoute,
        private router: Router,
       
    ) { }

    ngOnInit(): void {
        // Fetch the Department ID from the route parameters
        const NewsId = this.route.snapshot.params['id'];

        // Call the service to get the selected Department
        this.NewsService.getNewsById(NewsId).subscribe(
            (News: News) => {
                this.selectedNews = News;
            },
            (error) => {
                console.error('Error fetching News:', error);
            }
        );
         
    }

   
   
    updateNews(): void {
        // Call the service to update the Department
        this.NewsService.updateNews(this.selectedNews.id!, this.selectedNews).subscribe(
            () => {
                Swal.fire(
                    'Udpate!',
                    'Your News has been updated successefully.',
                    'success'
                );
                // Redirect to the Departments list or navigate to the desired page
                this.router.navigate(['/news/get']);
            },
            (error) => {
                console.error('Error updating news:', error);
            }
        );
    }

}
