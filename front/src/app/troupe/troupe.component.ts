import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-troupe',
  templateUrl: './troupe.component.html',
  styleUrls: ['./troupe.component.css']
})
export class TroupeComponent implements OnInit {

  currentUser:User;

  constructor() { }

  ngOnInit() {
  }

}
