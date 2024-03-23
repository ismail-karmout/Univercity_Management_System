import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Groupe} from "../models/groupes.module";

@Injectable({
  providedIn: 'root'
})
export class GroupesService {
  private apiUrl = 'http://localhost:9003/api/groups';

  constructor(private http: HttpClient) { }

  getAllGroups(): Observable<Groupe[]> {
    return this.http.get<Groupe[]>(this.apiUrl);
  }
  getGroupById(id: number): Observable<Groupe> {
    return this.http.get<Groupe>(`${this.apiUrl}/${id}`);
  }

  createGroup(section: Groupe): Observable<Groupe> {
    return this.http.post<Groupe>(this.apiUrl, section);
  }

  updateGroup(id: number, section: Groupe): Observable<Groupe> {
    return this.http.put<Groupe>(`${this.apiUrl}/${id}`, section);
  }

  deleteGroup(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

}
