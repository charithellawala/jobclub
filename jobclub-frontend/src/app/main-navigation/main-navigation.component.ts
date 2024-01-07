import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-navigation',
  templateUrl: './main-navigation.component.html',
  styleUrl: './main-navigation.component.scss'
})
export class MainNavigationComponent {

  constructor(private router: Router) {}

  goToCompanyRegistration() {
    this.router.navigate(['/company-registration']);
    // Navigate to the company registration page
  }

  goToJobVacancy() {
    this.router.navigate(['/jobvacancy-registration']);
    // Navigate to the job vacancy registration page
  }

}
