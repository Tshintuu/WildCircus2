import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { LogId } from '../log-id';
import { TokenService } from '../token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  loggedUser:string;

  constructor(private loginService:TokenService, private router:Router) {
   
   }

   logOut(){
    this.loginService.logout();
    location.reload();
    this.router.navigateByUrl("/");
  }

  ngOnInit() {
    

    

    
    
  }

}
