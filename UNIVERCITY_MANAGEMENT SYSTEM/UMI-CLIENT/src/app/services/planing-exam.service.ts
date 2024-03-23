import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlaningExam } from '../models/planing-exam.model';

@Injectable({
  providedIn: 'root'
})
export class PlaningExamService {

  
  private baseUrl = 'http://localhost:9012/api/planing-exams';

  constructor(private http: HttpClient) {}

//   savePlaningExam(planingExam:PlaningExam): Observable<PlaningExam> {
//     return this.http.post<PlaningExam>(this.baseUrl,planingExam);
//   }

    savePlaningExam(info: Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}`,info);
  }

  public getAllPlaningExams(): Observable<PlaningExam[]> {
    return this.http.get<PlaningExam[]>(this.baseUrl);
  }

  getPlaningExam(id: number): Observable<PlaningExam> {
    return this.http.get<PlaningExam>(`${this.baseUrl}/${id}`);
  }

  updatePlaningExam(planingExam:PlaningExam): Observable<PlaningExam> {
    return this.http.put<PlaningExam>(`${this.baseUrl}/${planingExam.id}`,planingExam);
  }

  deletePlaningExam(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }

  uploadFile(file: File): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post(`${this.baseUrl}/upload`, formData);
  }
}
