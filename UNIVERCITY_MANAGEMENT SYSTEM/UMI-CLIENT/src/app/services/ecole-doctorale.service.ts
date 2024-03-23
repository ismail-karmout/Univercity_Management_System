// EcoleDoctorale.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EcoleDoctorale } from '../models/ecole-doctorale.module';

@Injectable({
  providedIn: 'root'
})
export class EcoleDoctoraleService {
  private apiUrl = 'http://localhost:9016/api/ecole-doctorales';

  constructor(private http: HttpClient) { }

  getAllEcoleDoctorales(): Observable<EcoleDoctorale[]> {
    return this.http.get<EcoleDoctorale[]>(this.apiUrl);
  }
  getEcoleDoctoraleById(id: number): Observable<EcoleDoctorale> {
    return this.http.get<EcoleDoctorale>(`${this.apiUrl}/${id}`);
  }

  createEcoleDoctorale(ecoleDoctorale: EcoleDoctorale): Observable<EcoleDoctorale> {
    return this.http.post<EcoleDoctorale>(this.apiUrl, ecoleDoctorale);
  }

  updateEcoleDoctorale(id: number, ecoleDoctorale: EcoleDoctorale): Observable<EcoleDoctorale> {
    return this.http.put<EcoleDoctorale>(`${this.apiUrl}/${id}`, ecoleDoctorale);
  }

  deleteEcoleDoctorale(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

}
