import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Eventr } from '../models/eventr.module';

@Injectable({
  providedIn: 'root'
})
export class EventrService {

  private apiUrl = 'http://localhost:9002/api/eventR';

  constructor(private http: HttpClient) { }

  getAllEventr(): Observable<Eventr[]> {
    return this.http.get<Eventr[]>(this.apiUrl);
  }

  createEventr(eventr: FormData): Observable<Eventr> {
    return this.http.post<Eventr>(this.apiUrl, eventr);
  }

  getEventrById(id: number): Observable<Eventr> {
    return this.http.get<Eventr>(`${this.apiUrl}/${id}`);
  }

   
  updateEventr(id: number, eventr: Eventr): Observable<Eventr> {
    return this.http.put<Eventr>(`${this.apiUrl}/${id}`, eventr);
  }

  deleteEventr(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }
}
