import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PostDoc } from '../models/postDoc.model';

@Injectable({
  providedIn: 'root'
})
export class PostDocService {

  
  private baseUrl = 'http://localhost:9013/api/postDocs';

  constructor(private http: HttpClient) {}

  savePostDoc(postDoc: PostDoc): Observable<PostDoc> {
    return this.http.post<PostDoc>(this.baseUrl, postDoc);
  }

  public getAllPostDocs(): Observable<PostDoc[]> {
    return this.http.get<PostDoc[]>(this.baseUrl);
  }

  getPostDoc(id: number): Observable<PostDoc> {
    return this.http.get<PostDoc>(`${this.baseUrl}/${id}`);
  }

  updatePostDoc(postDoc: PostDoc): Observable<PostDoc> {
    return this.http.put<PostDoc>(`${this.baseUrl}/${postDoc.id}`, postDoc);
  }

  deletePostDoc(id:number): Observable<any>{
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }
}
