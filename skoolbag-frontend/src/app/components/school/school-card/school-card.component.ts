import { Component, OnInit, Input } from '@angular/core';
import { School } from '../models/School';

@Component({
  selector: 'app-school-card',
  templateUrl: './school-card.component.html',
  styleUrls: ['./school-card.component.css']
})
export class SchoolCardComponent implements OnInit {

  @Input()
  school: School;

  constructor() { }

  ngOnInit(): void {
  }

}
