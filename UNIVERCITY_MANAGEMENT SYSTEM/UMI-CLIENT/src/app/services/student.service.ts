import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:9010/api/students';

  constructor(private http: HttpClient) {}

  saveStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(this.baseUrl, student);
  }

  exportToExcelStudents(): Observable<Blob> {
    return this.http.get(`${this.baseUrl}/export-to-excel`, { responseType: 'blob' });
  }

  public getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl);
  }

  getStudent(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseUrl}/${id}`);
  }

  updateStudent(student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.baseUrl}/${student.id}`, student);
  }

  deleteStudent(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }

  uploadStudents(formData: FormData) {
    return this.http.post<any>(`${this.baseUrl}/upload-students`, formData);
  }
}
