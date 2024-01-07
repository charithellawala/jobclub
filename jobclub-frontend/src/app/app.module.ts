import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyRegistrationComponent } from './company-registration/company-registration.component';
import { JobpostRegistrationComponent } from './jobpost-registration/jobpost-registration.component';
import { LoginComponent } from './login/login.component';
import { MainNavigationComponent } from './main-navigation/main-navigation.component';
import { provideHttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CompanyRegistrationComponent,
    JobpostRegistrationComponent,
    LoginComponent,
    MainNavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
