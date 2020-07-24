import { Component, OnInit, ViewChild } from '@angular/core';
import { SchoolService } from '../services/school.service';
import { School } from '../models/School';

@Component({
  selector: 'app-list-schools',
  templateUrl: './list-schools.component.html',
  styleUrls: ['./list-schools.component.css']
})
export class ListSchoolsComponent implements OnInit {

  schools: School[];


  constructor(private schoolService: SchoolService) { }

  ngOnInit(): void {
    this.schoolService.getSchools().subscribe(schools => {
        this.schools = schools;        
      });
  }
}
