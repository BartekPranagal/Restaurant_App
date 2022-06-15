import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainPageComponent} from "./components/MainPage/main-page/main-page.component";
import {LoginPageComponent} from "./components/loginPage/login-page/login-page.component";
import {RatingPageComponent} from "./components/ratingPage/rating-page/rating-page.component";
import {RegisterPageComponent} from "./components/registerPage/register-page/register-page.component";
import {AdminPageComponent} from "./components/adminPage/admin-page/admin-page.component";
import {EditPageComponent} from "./components/editPage/edit-page/edit-page.component";
import {UserPageComponent} from "./components/userPage/user-page/user-page.component";

const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'rating/:id', component: RatingPageComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'admin', component: AdminPageComponent},
  {path: 'edit/:id', component: EditPageComponent},
  {path: 'user', component: UserPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
