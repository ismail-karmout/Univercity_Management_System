import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Etablissement } from './../models/etablissement.module';

@Injectable({
    providedIn: 'root'
})
export class EtablissementService {
    private apiUrl = 'http://localhost:9005/api/ed/etablissements';

    constructor(private http: HttpClient) {}

    getAllEtablissements(): Observable<Etablissement[]> {
        return this.http.get<Etablissement[]>(this.apiUrl);
    }

    getEtablissementById(id: number): Observable<Etablissement> {
        return this.http.get<Etablissement>(`${this.apiUrl}/${id}`);
    }

    createEtablissement(etablissement: Etablissement): Observable<Etablissement> {
        return this.http.post<Etablissement>(this.apiUrl, etablissement);
    }

    updateEtablissement(id: number, etablissement: Etablissement): Observable<Etablissement> {
        return this.http.put<Etablissement>(`${this.apiUrl}/${id}`, etablissement);
    }

    deleteEtablissement(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
