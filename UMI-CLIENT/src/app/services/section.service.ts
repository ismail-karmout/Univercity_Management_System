import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Section} from "../models/section.module";

@Injectable({
  providedIn: 'root'
})
export class SectionService {
  private apiUrl = 'http://localhost:9003/api/sections';

  constructor(private http: HttpClient) { }

  getAllSections(): Observable<Section[]> {
    return this.http.get<Section[]>(this.apiUrl);
  }
  getSectionById(id: number): Observable<Section> {
    return this.http.get<Section>(`${this.apiUrl}/${id}`);
  }

  createSection(section: Section): Observable<Section> {
    return this.http.post<Section>(this.apiUrl, section);
  }

  updateSection(id: number, section: Section): Observable<Section> {
    return this.http.put<Section>(`${this.apiUrl}/${id}`, section);
  }

  deleteSection(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

}
