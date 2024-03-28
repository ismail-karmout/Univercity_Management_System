import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AnneeUniversitaire } from '../models/anneeUniversitaire.module'; 

@Injectable({
  providedIn: 'root'
})
export class AnneeUniversitaireService {
  private apiUrl = 'http://localhost:9009/api/anneeUniversitaires';

  constructor(private http: HttpClient) {}

  getAllAnneesUniversitaires(): Observable<AnneeUniversitaire[]> {
    return this.http.get<AnneeUniversitaire[]>(this.apiUrl);
  }

  getAnneeUniversitaireById(id: number): Observable<AnneeUniversitaire> {
    return this.http.get<AnneeUniversitaire>(`${this.apiUrl}/${id}`);
  }

  createAnneeUniversitaire(anneeUniversitaire: AnneeUniversitaire): Observable<AnneeUniversitaire> {
    return this.http.post<AnneeUniversitaire>(this.apiUrl, anneeUniversitaire);
  }

  updateAnneeUniversitaire(id: number, anneeUniversitaire: AnneeUniversitaire): Observable<AnneeUniversitaire> {
    return this.http.put<AnneeUniversitaire>(`${this.apiUrl}/${id}`, anneeUniversitaire);
  }

  deleteAnneeUniversitaire(id: number): Observable<void> {  
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
