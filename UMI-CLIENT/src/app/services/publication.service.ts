import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Publication } from './../models/publication.model';

@Injectable({
  providedIn: 'root'
})
export class PublicationService {
 
  private apiUrl = 'http://localhost:9015/api/publications';

  constructor(private http: HttpClient) { }

  getAllPublications(): Observable<Publication[]> {
    return this.http.get<Publication[]>(this.apiUrl);
  }
  getPublicationById(id: number): Observable<Publication> {
    return this.http.get<Publication>(`${this.apiUrl}/${id}`);
  }

  getPublicationByAnnee(id: number): Observable<Publication> {
    return this.http.get<Publication>(`${this.apiUrl}/annee/${id}`);
  }
  getPublicationByEquipe(id: number): Observable<Publication> {
    return this.http.get<Publication>(`${this.apiUrl}/equipe/${id}`);
  }
  getPublicationByAuteur(id: number): Observable<Publication> {
    return this.http.get<Publication>(`${this.apiUrl}/auteur/${id}`);
  }
  getPublicationByLabo(id: number): Observable<Publication> {
    return this.http.get<Publication>(`${this.apiUrl}/labo/${id}`);
  }


  addPublication(publication: Publication): Observable<Publication> {
    return this.http.post<Publication>(this.apiUrl, publication);
  }

  updatePublication(id: number, publication: Publication): Observable<Publication> {
    return this.http.put<Publication>(`${this.apiUrl}/${id}`, publication);
  }

  deletePublication(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

}
