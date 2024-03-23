import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Labo } from '../models/labo.module';

@Injectable({
    providedIn: 'root'
})
export class LaboService {
    private apiUrl = 'http://localhost:9011/api/labos';

    constructor(private http: HttpClient) { }

    getAllLabos(): Observable<Labo[]> {
        return this.http.get<Labo[]>(this.apiUrl);
    }

    getLaboById(id: number): Observable<Labo> {
        return this.http.get<Labo>(`${this.apiUrl}/${id}`);
    }

    createLabo(labo: Labo): Observable<Labo> {
        return this.http.post<Labo>(this.apiUrl, labo);
    }

    updateLabo(id: number, labo: Labo): Observable<Labo> {
        return this.http.put<Labo>(`${this.apiUrl}/${id}`, labo);
    }

    deleteLabo(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}