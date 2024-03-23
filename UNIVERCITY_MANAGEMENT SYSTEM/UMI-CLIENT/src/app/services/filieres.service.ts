import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Filiere } from '../models/filiere.module';
@Injectable({
  providedIn: 'root'
})
export class FilieresService {
  private apiUrl = 'http://localhost:9006/api/filiere';

  constructor(private http: HttpClient) { }

  getAllFilieres(): Observable<Filiere[]> {
    return this.http.get<Filiere[]>(this.apiUrl);
  }

  getFiliereById(id: number): Observable<Filiere> {
    return this.http.get<Filiere>(`${this.apiUrl}/${id}`);
  }

  addFiliere(filiere: Filiere): Observable<Filiere> {
    return this.http.post<Filiere>(this.apiUrl, filiere);
  }

  updateFiliere(id: number, filiere: Filiere): Observable<Filiere> {
    return this.http.put<Filiere>(`${this.apiUrl}/${id}`, filiere);
  }

  deleteFiliere(id: number): Observable<void> {  
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}