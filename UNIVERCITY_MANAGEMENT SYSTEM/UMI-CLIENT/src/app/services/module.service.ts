import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';
import { Module } from '../models/module.model';


@Injectable({
  providedIn: 'root'
})

export class ModuleService {

  private baseUrl = 'http://localhost:9008/api/modules';

  constructor(private http: HttpClient) {}

  saveModule(module: Module): Observable<Module> {
    return this.http.post<Module>(this.baseUrl, module);
  }

  public getAllModules(): Observable<Module[]> {
    return this.http.get<Module[]>(this.baseUrl);
  }

  getModule(id: number): Observable<Module> {
    return this.http.get<Module>(`${this.baseUrl}/${id}`);
  }

  updateModule(module: Module): Observable<Module> {
    return this.http.put<Module>(`${this.baseUrl}/${module.id}`, module);
  }

  deleteModule(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }
}
 
