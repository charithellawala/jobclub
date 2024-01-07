import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobpostRegistrationComponent } from './jobpost-registration.component';

describe('JobpostRegistrationComponent', () => {
  let component: JobpostRegistrationComponent;
  let fixture: ComponentFixture<JobpostRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobpostRegistrationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobpostRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
