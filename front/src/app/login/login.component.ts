import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { LogId } from '../log-id';
import { TokenService } from '../token.service';
import { UserService } from '../user.service';
import { RegisterService } from '../register.service';

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
  regUsername:string;
  regPassword:string;
  wrongCredentials:boolean;
  userId:number;

  constructor(private loginService:TokenService, private service:UserService, private registerService:RegisterService, private router:Router) {

    this.userList = [];

   }

  modalDisplay(buttonType) {
    document.getElementById(buttonType).style.display = "block";
  }

  closeModal(buttonType) {
    document.getElementById(buttonType).style.display = "none";
    this.username = null;
    this.password = null;
  }

  signIn() {
    console.log("Signing in...");
    let logObject = {
      "username" : this.username,
      "password" : this.password
    }
    this.loginService.login(logObject).subscribe(
      () => {
        if (this.service.getToken()!= null ){
          this.router.navigateByUrl("/troupe");
          console.log("Granted, navigating");
        } else {
          this.wrongCredentials = true;
          console.log("Denied...");
        }
      }
    );
  }

  signUp() {
    let jsonObject = {
      "username" : this.username,
      "password" : this.password
    }

    this.registerService.register(jsonObject).subscribe();
    console.log("username: "+this.username);
    console.log("done "+ jsonObject.username + ", " + jsonObject.password);

  }

  ngOnInit() {

    
    
  }

}
