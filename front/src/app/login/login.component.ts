import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  modalDisplay(buttonType) {
    document.getElementById(buttonType).style.display = "block";
  }

  closeModal(buttonType) {
    document.getElementById(buttonType).style.display = "none";
  }

  ngOnInit() {
  }

}
