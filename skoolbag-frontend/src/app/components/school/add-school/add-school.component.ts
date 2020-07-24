import { Component, OnInit } from '@angular/core';
import { SchoolService } from '../services/school.service';
import { School } from '../models/School';
import { Response } from '../models/Response';
import { Address } from '../models/Address';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-school',
  templateUrl: './add-school.component.html',
  styleUrls: ['./add-school.component.css']
})
export class AddSchoolComponent implements OnInit {

  school: School;
  address: Address;

  form: FormGroup;
  formSubmitted = false;

  response: Response;

  constructor(private schoolService: SchoolService, private formBuilder: FormBuilder,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      schoolName: [null, [Validators.required]],
      noOfStudents: [null, [Validators.required]],
      street: [null, [Validators.required]],
      postcode: [null, [Validators.required]],
      suburb: [null, [Validators.required]],
      state: [null, [Validators.required]]
    });
  }

  onSubmit(event): void {
    event.preventDefault();
    this.formSubmitted = true;
    if (this.form.valid) {
      this.save();
    }
  }

  save(): void {
    this.school = new School();
    this.school.name = this.form.get('schoolName').value;
    this.school.noOfStudents = this.form.get('noOfStudents').value;
    this.address = new Address();
    this.school.address = this.address;
    this.address.street = this.form.get('street').value;
    this.address.postCode = this.form.get('postcode').value;
    this.address.suburb = this.form.get('suburb').value;
    this.address.state = this.form.get('state').value;
    this.schoolService.saveSchool(this.school).subscribe(response => {
      if ('SUCCESS' === response.status) {
        this.toastr.success('New School Added.');
      } else {
        this.toastr.error('Error occurred.');
      }
    });
  }
}
