import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Professor } from '../models/professor.model';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  
  private baseUrl = 'http://localhost:9013/api/professors';

  constructor(private http: HttpClient) {}

  saveProfessor(professor: Professor): Observable<Professor> {
    return this.http.post<Professor>(this.baseUrl, professor);
  }

  public getAllProfessors(): Observable<Professor[]> {
    return this.http.get<Professor[]>(this.baseUrl);
  }

  getProfessor(id: number): Observable<Professor> {
    return this.http.get<Professor>(`${this.baseUrl}/${id}`);
  }

  updateProfessor(professor: Professor): Observable<Professor> {
    return this.http.put<Professor>(`${this.baseUrl}/${professor.id}`, professor);
  }

  deleteProfessor(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }
}
