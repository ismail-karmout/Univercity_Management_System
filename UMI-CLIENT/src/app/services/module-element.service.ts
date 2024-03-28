import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ModuleElement } from '../models/moduleElement.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModuleElementService {

  
  private baseUrl = 'http://localhost:9008/api/module-elements';

  constructor(private http: HttpClient) {}

  saveModuleElement(moduleElement: ModuleElement): Observable<ModuleElement> {
    return this.http.post<ModuleElement>(this.baseUrl, moduleElement);
  }

  public getAllModuleElements(): Observable<ModuleElement[]> {
    return this.http.get<ModuleElement[]>(this.baseUrl);
  }

  getModuleElement(id: number): Observable<ModuleElement> {
    return this.http.get<ModuleElement>(`${this.baseUrl}/${id}`);
  }

  updateModuleElement(moduleElement: ModuleElement): Observable<ModuleElement> {
    return this.http.put<ModuleElement>(`${this.baseUrl}/${moduleElement.id}`, moduleElement);
  }

  deleteModuleElement(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }
}
