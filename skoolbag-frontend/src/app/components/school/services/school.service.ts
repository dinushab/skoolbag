import { Injectable } from '@angular/core';

import { School } from '../models/School';
import { HttpProviderService} from './http-provider.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {

  schoolsUrl: string = '/api/v1/schools';
  searchSchoolsUrl: string = '/api/v1/schools/search';  

  constructor(private httpService: HttpProviderService) { }

  getSchools():Observable<any> {
    return this.httpService.getForObject(this.schoolsUrl);
  }

  saveSchool(school: School): Observable<any> {
    return this.httpService.postForObject(this.schoolsUrl, school)
  }

  searchSchool(name:string, address:string): Observable<any> {
    let url: string = this.searchSchoolsUrl + '?schoolName=' + name + '&address=' + address;
    return this.httpService.getForObject(url);
  }
}