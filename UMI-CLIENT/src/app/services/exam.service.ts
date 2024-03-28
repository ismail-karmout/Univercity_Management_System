import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from '../models/exam.model';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  
  private baseUrl = 'http://localhost:9012/api/exams';

  constructor(private http: HttpClient) {}

  saveExam(exam:Exam): Observable<Exam> {
    return this.http.post<Exam>(this.baseUrl,exam);
  }


  public getAllExams(): Observable<Exam[]> {
    return this.http.get<Exam[]>(this.baseUrl);
  }

  getExam(id: number): Observable<Exam> {
    return this.http.get<Exam>(`${this.baseUrl}/${id}`);
  }

  updateExam(exam:Exam): Observable<Exam> {
    return this.http.put<Exam>(`${this.baseUrl}/${exam.id}`,exam);
  }

  deleteExam(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }

}
