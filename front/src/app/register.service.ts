import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const HttpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
 };

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private url:string = "http://localhost:8080/authenticate"

  constructor(private http:HttpClient) { }

  public register(data: any): Observable<any> {
    return this.http.post(this.url, data, HttpOptions)
  }
}
