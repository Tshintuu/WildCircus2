import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { LogId } from '../log-id';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  currentUser:User;
  userList:User[];
  username:string;
  password: string;
  wrongCredentials:boolean;
  userId:number;

  constructor(private authService:AuthenticationService, private router:Router) {

    this.userList = [];

   }

  modalDisplay(buttonType) {
    document.getElementById(buttonType).style.display = "block";
    this.authService.loggedUser(null).subscribe();
  }

  closeModal(buttonType) {
    document.getElementById(buttonType).style.display = "none";
    this.username = null;
    this.password = null;
  }

  signIn() {
    for(let i = 0; i < this.userList.length; i++) {
      if(this.username == this.userList[i].username && this.password == this.userList[i].password) {
        this.router.navigateByUrl("/troupe");

        let logObject = {
          "username" : this.userList[i].username
        }
        this.authService.loggedUser(logObject).subscribe();
      } else {
        this.wrongCredentials = true;
      }
    }
  }

  signUp() {
    let jsonObject = {
      "id" : this.userList.length + 1,
      "username" : this.username,
      "password" : this.password
    }

    this.authService.addUser(jsonObject).subscribe();
    console.log("done");

  }

  ngOnInit() {

    this.authService.getUser().subscribe(
      (param_data:User[]) => {
        this.userList = param_data;
      }
    );
    
    
  }

}
