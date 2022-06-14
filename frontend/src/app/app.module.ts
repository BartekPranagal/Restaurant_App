import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import {MaterialModule} from "./modules/material/material.module";
import { TopBarComponent } from './components/MainPage/top-bar/top-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PizzaListComponent } from './components/MainPage/pizza-list/pizza-list.component';
import { PizzaItemComponent } from './components/MainPage/pizza-item/pizza-item.component';
import { PizzalistCartComponent } from './components/MainPage/pizzalist-cart/pizzalist-cart.component';
import { CartComponent } from './components/MainPage/cart/cart.component';
import { PackageForPizzalistCartComponent } from './components/MainPage/package-for-pizzalist-cart/package-for-pizzalist-cart.component';
import { InfoComponent } from './components/MainPage/info/info.component';
import { PromoComponent } from './components/MainPage/promo/promo.component';
import { PizzaOrderItemComponent } from './components/MainPage/pizza-order-item/pizza-order-item.component';
import { MainPageComponent } from './components/MainPage/main-page/main-page.component';
import { RatingPageComponent } from './components/ratingPage/rating-page/rating-page.component';
import { LoginPageComponent } from './components/loginPage/login-page/login-page.component';
import { TopBarLoginComponent } from './components/loginPage/top-bar-login/top-bar-login.component';
import { TopBarRatingComponent } from './components/ratingPage/top-bar-rating/top-bar-rating.component';
import { RatingMainComponent } from './components/ratingPage/rating-main/rating-main.component';
import { LoginMainComponent } from './components/loginPage/login-main/login-main.component';
import { RatingListComponent } from './components/ratingPage/rating-list/rating-list.component';
import { RatingItemComponent } from './components/ratingPage/rating-item/rating-item.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RegisterPageComponent } from './components/registerPage/register-page/register-page.component';
import { TopBarRegisterComponent } from './components/registerPage/top-bar-register/top-bar-register.component';
import { RegisterMainComponent } from './components/registerPage/register-main/register-main.component';
import { AdminPageComponent } from './components/adminPage/admin-page/admin-page.component';
import { TopBarAdminComponent } from './components/adminPage/top-bar-admin/top-bar-admin.component';
import { AdminMainComponent } from './components/adminPage/admin-main/admin-main.component';
import { EditPageComponent } from './components/editPage/edit-page/edit-page.component';
import { EditMainComponent } from './components/editPage/edit-main/edit-main.component';
import { TopBarEditComponent } from './components/editPage/top-bar-edit/top-bar-edit.component';
import { UserPageComponent } from './components/userPage/user-page/user-page.component';
import { UserMainComponent } from './components/userPage/user-main/user-main.component';
import {FileSaverModule} from "ngx-filesaver";

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    PizzaListComponent,
    PizzaItemComponent,
    PizzalistCartComponent,
    CartComponent,
    PackageForPizzalistCartComponent,
    InfoComponent,
    PromoComponent,
    PizzaOrderItemComponent,
    MainPageComponent,
    RatingPageComponent,
    LoginPageComponent,
    TopBarLoginComponent,
    TopBarRatingComponent,
    RatingMainComponent,
    LoginMainComponent,
    RatingListComponent,
    RatingItemComponent,
    RegisterPageComponent,
    TopBarRegisterComponent,
    RegisterMainComponent,
    AdminPageComponent,
    TopBarAdminComponent,
    AdminMainComponent,
    EditPageComponent,
    EditMainComponent,
    TopBarEditComponent,
    UserPageComponent,
    UserMainComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    MaterialModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FileSaverModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
