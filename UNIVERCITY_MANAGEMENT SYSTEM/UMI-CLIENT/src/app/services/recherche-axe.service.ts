// RechercheAxe.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RechercheAxe } from '../models/recherche-axe.module';

@Injectable({
  providedIn: 'root'
})
export class RechercheAxeSercice {
  private apiUrl = 'http://localhost:9011/api/recherche-axes';

  constructor(private http: HttpClient) { }

  getAllRechercheAxes(): Observable<RechercheAxe[]> {
    return this.http.get<RechercheAxe[]>(this.apiUrl);
  }
  getRechercheAxeById(id: number): Observable<RechercheAxe> {
    return this.http.get<RechercheAxe>(`${this.apiUrl}/${id}`);
  }

  createRechercheAxe(rechercheAxe: RechercheAxe): Observable<RechercheAxe> {
    return this.http.post<RechercheAxe>(this.apiUrl, rechercheAxe);
  }

  updateRechercheAxe(id: number, rechercheAxe: RechercheAxe): Observable<RechercheAxe> {
    return this.http.put<RechercheAxe>(`${this.apiUrl}/${id}`, rechercheAxe);
  }

  deleteRechercheAxe(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

}
