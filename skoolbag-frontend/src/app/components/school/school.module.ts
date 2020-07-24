import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ListSchoolsComponent } from './list-schools/list-schools.component';
import { AddSchoolComponent } from './add-school/add-school.component';
import { SearchSchoolComponent } from './search-school/search-school.component';
import { SchoolCardComponent } from './school-card/school-card.component';
import { SchoolRoutingModule } from './school-routing/school-routing.module';

@NgModule({
  declarations: [
    ListSchoolsComponent,
    AddSchoolComponent,
    SearchSchoolComponent,
    SchoolCardComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SchoolRoutingModule ]
})
export class SchoolModule { }
