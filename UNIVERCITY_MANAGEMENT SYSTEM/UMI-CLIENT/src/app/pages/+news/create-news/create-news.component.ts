import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../../services/news.service';
import { Router } from '@angular/router';
import { News } from '../../../models/news.module';
import Swal from 'sweetalert2';
import { DomSanitizer } from '@angular/platform-browser';
import { FileHandle } from '../../../models/file-handel.model';
import { Department } from '../../../models/department.module';
import { DepartmentService } from '../../../services/department.service';

@Component({
  selector: 'app-create-news',
  templateUrl: './create-news.component.html',
  styleUrls: ['./create-news.component.css']
})
export class CreateNewsComponent implements OnInit {

  news: News[] = [];
  department: Department[] = [];
  newNews: News = { title: '', date: '', description: '', type: '',  newsImages: [] ,  department_id:{id: 0} };
  

  constructor(
    private newService: NewsService,
    private departmentService: DepartmentService,
    private router: Router,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.loadDepartments();
    this.loadNews();
  }
  loadDepartments(): void {
    this.departmentService.getAllDepartments().subscribe(Departments => {
        this.department = Departments;
    });
}

  loadNews(): void {
    this.newService.getAllNews().subscribe(news => {
      this.news = news;
    });
  }

  createNews(): void {
    const newsFormData = this.prepareFormData(this.newNews);
    
    this.newService.createNews(newsFormData).subscribe(() => {
      this.loadNews();
      this.newNews = { title: '', date: '', description: '', type: '', department_id:{id: 0} ,  newsImages: [] }; // Ajout de newsImages: []
 
      Swal.fire(
        'Create!',
        'Your new has been created successfully.',
        'success'
      );
      this.router.navigate(['/news/create']);
    });
  }

  prepareFormData(newNews: News): FormData {
    const formData = new FormData();

    formData.append(
      'newsDto' , new Blob([JSON.stringify(newNews)] , {type: 'application/json'})
    );

    for(let i = 0; i < newNews.newsImages.length; i++){
      formData.append(
        'imageFile' , 
        newNews.newsImages[i].file,
        newNews.newsImages[i].file.name
      );
    }

    return formData;
  }
  
  onSelectFile(event: any): void {
    if(event.target.files){
      const file = event.target.files[0];
      const fileHand: FileHandle = {
        file: file,
        url: this.sanitizer.bypassSecurityTrustUrl(
           window.URL.createObjectURL(file)
        )
      };
      if(!this.newNews.newsImages){
        this.newNews.newsImages = []; // Initialiser newNews.newsImages s'il est null ou undefined
      }
      this.newNews.newsImages.push(fileHand);
    }
  }

  removeImage(i : number){
    this.newNews.newsImages.splice(i, 1);

  }
}
