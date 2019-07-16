import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hire',
  templateUrl: './hire.component.html',
  styleUrls: ['./hire.component.css']
})
export class HireComponent implements OnInit {

  constructor() { }

  modalDisplay() {
    document.getElementById("hireModal").style.display="block";
  }

  closeModal() {
    document.getElementById("hireModal").style.display="none";
  }

  ngOnInit() {
  }

}
