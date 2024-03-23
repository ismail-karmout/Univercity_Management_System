import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { News } from '../models/news.module';

 
@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private apiUrl = 'http://localhost:9004/api/news';

  constructor(private http: HttpClient) { }

   
  getAllNews(): Observable<News[]> {
    return this.http.get<News[]>(this.apiUrl);
  }

  createNews(news: FormData): Observable<News> {
    return this.http.post<News>(this.apiUrl, news);
  }

  getNewsById(id: number): Observable<News> {
    return this.http.get<News>(`${this.apiUrl}/${id}`);
  }

   
  updateNews(id: number, news: News): Observable<News> {
    return this.http.put<News>(`${this.apiUrl}/${id}`, news);
  }

  deleteNews(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }
}
