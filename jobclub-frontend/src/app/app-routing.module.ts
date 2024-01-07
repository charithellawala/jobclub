import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyRegistrationComponent } from './company-registration/company-registration.component';
import { JobpostRegistrationComponent } from './jobpost-registration/jobpost-registration.component';
import { LoginComponent } from './login/login.component';
import { MainNavigationComponent } from './main-navigation/main-navigation.component';
import { AuthService } from './services/auth-service';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'navigation', component: MainNavigationComponent ,canActivate: [AuthService]},
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },
  { path: 'company-registration', component: CompanyRegistrationComponent },
  { path: 'jobvacancy-registration', component: JobpostRegistrationComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
