import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { LogId } from '../log-id';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  loggedUser:string;

  constructor(private authService:AuthenticationService) {
   
   }

  ngOnInit() {
    

    /*this.authService.getLoggedUser().subscribe(
      (param_data:LogId) => {
        this.loggedUser = param_data.username;
      }
    )*/

    
    
  }

}
