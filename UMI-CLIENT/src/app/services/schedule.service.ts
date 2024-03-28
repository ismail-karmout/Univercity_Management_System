import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Schedule} from "../models/schedule.module";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  private apiUrl = 'http://localhost:9003/api/schedules';
  private selectedFile:File=new File([""], "default.pdf");
  constructor(private http: HttpClient) { }

  getAllSchedules(): Observable<Schedule[]> {
    return this.http.get<Schedule[]>(this.apiUrl);
  }
  getScheduleById(id: number): Observable<Schedule> {
    return this.http.get<Schedule>(`${this.apiUrl}/${id}`);
  }
  getScheduleBySectionId(id:number):Observable<Schedule>{
    return this.http.get<Schedule>(`${this.apiUrl}/section/${id}`);
  }
  createSchedule(param: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, param);
  }

  updateSchedule(id: number, param: any): Observable<Schedule> {
    return this.http.put<Schedule>(`${this.apiUrl}/${id}`, param);
  }

  deleteSchedule(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }
  onFileSelected(event: Event): void {
    const inputElement = event.target as HTMLInputElement;

    if (inputElement.files && inputElement.files.length > 0)
      this.selectedFile = inputElement.files[0];
    console.log(this.selectedFile)
    const fd = new FormData();
    fd.append('file', this.selectedFile);
    this.http.post('http://localhost:9003/api/schedules/upload', fd)
      .subscribe(res => {
        console.log(res);
        // Handle response as needed
      });
  }
}
