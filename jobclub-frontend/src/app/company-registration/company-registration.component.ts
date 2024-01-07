import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-company-registration',
  templateUrl: './company-registration.component.html',
  styleUrl: './company-registration.component.scss'
})
export class CompanyRegistrationComponent implements OnInit{
  companyForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.companyForm = this.fb.group({
      companyName: ['', [Validators.required]],
      location: ['', [Validators.required]],
      country: ['', [Validators.required]],
    });
  }

  onSubmit() {
    if (this.companyForm.valid) {
      // Process the form data (e.g., send to a backend server)
      console.log(this.companyForm.value);
    } else {
      // Handle form validation errors
      console.log('Form is invalid');
    }
  }
}
