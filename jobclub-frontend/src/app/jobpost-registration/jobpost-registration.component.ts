import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-jobpost-registration',
  templateUrl: './jobpost-registration.component.html',
  styleUrl: './jobpost-registration.component.scss'
})
export class JobpostRegistrationComponent implements OnInit{

  jobVacancyForm!: FormGroup;

  // Sample data for the company dropdown (replace with your backend call)
  companies: string[] = ['Company A', 'Company B', 'Company C'];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.jobVacancyForm = this.fb.group({
      companyName: ['', Validators.required],
      jobTitle: ['', Validators.required],
      date: ['', Validators.required],
      location: ['', Validators.required],
      description: ['', Validators.required],
      requirements: [''],
    });
  }

  onSubmit() {
    if (this.jobVacancyForm.valid) {
      // Process the form data (e.g., send to a backend server)
      console.log(this.jobVacancyForm.value);
    } else {
      // Handle form validation errors
      console.log('Form is invalid');
    }
  }

}
