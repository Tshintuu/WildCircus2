import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

const HttpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
 };

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  public token: string;
  private url = 'http://localhost:8080/authenticate'

  constructor(private http: HttpClient,private service:UserService) {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
   }

   public login(data: any): Observable<any> {
     return this.http.post<any>(this.url, data, HttpOptions)
     .pipe(
      map(user => {
        if (user && user.token) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.service.setToken(user.token);
         
        }
        return user;
      })
    );
   }

   logout(): void {
     this.token = null;
     localStorage.removeItem('currentUser');
   }
}
