import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';
import { LogId } from './log-id';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }

  /*userUrl = "http://localhost:3000/user";
  logUrl = "http://localhost:3000/loggedUser"

  public getUser():Observable<User[]> {
    return this.http.get<User[]>(this.userUrl).pipe(
      map(
        (param_data:any) => {
          return param_data as User[];
        }
      )
    )
  }

  public addUser(user:User):Observable<User> {
    return this.http.post<User>(this.userUrl, user)
  }

  public loggedUser(username:LogId):Observable<LogId> {
    return this.http.put<LogId>(this.logUrl, username)
  }

  public getLoggedUser():Observable<LogId> {
    return this.http.get<LogId>(this.logUrl)
  }*/
}
