import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PhdStudent } from '../models/phdStudent.model';

@Injectable({
  providedIn: 'root'
})
export class PhdStudentService {

  
  private baseUrl = 'http://localhost:9013/api/phdStudents';

  constructor(private http: HttpClient) {}

  savePhdStudent(phdStudent: PhdStudent): Observable<PhdStudent> {
    return this.http.post<PhdStudent>(this.baseUrl, phdStudent);
  }

  public getAllPhdStudents(): Observable<PhdStudent[]> {
    return this.http.get<PhdStudent[]>(this.baseUrl);
  }

  getPhdStudent(id: number): Observable<PhdStudent> {
    return this.http.get<PhdStudent>(`${this.baseUrl}/${id}`);
  }

  updatePhdStudent(phdStudent: PhdStudent): Observable<PhdStudent> {
    return this.http.put<PhdStudent>(`${this.baseUrl}/${phdStudent.id}`, phdStudent);
  }

  deletePhdStudent(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }
}
