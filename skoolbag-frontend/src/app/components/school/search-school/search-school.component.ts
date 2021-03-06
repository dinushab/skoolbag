import { Component, OnInit } from '@angular/core';
import { School } from '../models/School';
import { SchoolService } from '../services/school.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-search-school',
  templateUrl: './search-school.component.html',
  styleUrls: ['./search-school.component.css']
})
export class SearchSchoolComponent implements OnInit {

  searchSchoolName = '';
  searchSchoolAddress = '';
  schools: School;

  formSubmitted = false;b

  constructor(private schoolService: SchoolService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  search(): void {
    this.schoolService.searchSchool(this.searchSchoolName, this.searchSchoolAddress)
      .subscribe(response => {
        this.schools = response;
      });
  }

  onSubmit(event): void {
    event.preventDefault();
    if (this.searchSchoolName.length === 0 && this.searchSchoolAddress.length === 0) {
      this.toastr.error('Please provide the school name and/or the address to do a search');
    } else {
      this.search();
    }
  }
}
