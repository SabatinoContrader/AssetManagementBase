import { BadgeService } from 'src/services/badge.service';
import { HomeCustomerComponent } from './../components/home-customer/home-customer.component';
import { UserService } from './../services/user.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from '../components/login/login.component';
import { HomeSegretariaComponent } from '../components/home-segretaria/home-segretaria.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
//import { AgmCoreModule } from '@agm/core';
import { AppRoutingModule } from './app-routing.module';
import { ManagementUserComponent } from '../components/management-user/management-user.component';
import { MenuCustomerComponent } from '../menu/menu-customer/menu-customer.component';
import { MenuHomeSegretariaComponent } from '../menu/menu-home-segretaria/menu-home-segretaria.component';
import { ManagementBadgeComponent } from '../components/management-badge/management-badge.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeSegretariaComponent,
    HomeCustomerComponent,
    ManagementUserComponent,
    MenuCustomerComponent,
    MenuHomeSegretariaComponent,
    ManagementBadgeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule/*,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAUf_fIZF0iu40Uiwhj3RhFE3Kd1KrWUFw',
      libraries: ["places"]
    })*/
  ],
  providers: [UserService,BadgeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
