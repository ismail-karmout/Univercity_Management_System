import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Semestre } from '../models/semestre.module'; 

@Injectable({
  providedIn: 'root'
})
export class SemestresService {
 
  private apiUrl = 'http://localhost:9009/api/semestres';

  constructor(private http: HttpClient) {}

  getAllSemestres(): Observable<Semestre[]> {
    return this.http.get<Semestre[]>(this.apiUrl);
  }
  

  getSemestreById(id: number): Observable<Semestre> {
    return this.http.get<Semestre>(`${this.apiUrl}/${id}`);
  }

  createSemestre(semestre: Semestre): Observable<Semestre> {
    return this.http.post<Semestre>(this.apiUrl, semestre);
  }

  updateSemestre(id: number, semestre: Semestre): Observable<Semestre> {
    return this.http.put<Semestre>(`${this.apiUrl}/${id}`, semestre);
  }

  deleteSemestre(id: number): Observable<void> {  
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
