import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListSchoolsComponent } from '../list-schools/list-schools.component';
import { AddSchoolComponent } from '../add-school/add-school.component';
import { SearchSchoolComponent } from '../search-school/search-school.component';

const schoolRoutes: Routes = [
  { path: 'list', component: ListSchoolsComponent },
  { path: 'addschool', component: AddSchoolComponent },
  { path: 'searchschool', component: SearchSchoolComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(schoolRoutes)],
  exports: [RouterModule]
})
export class SchoolRoutingModule { }
