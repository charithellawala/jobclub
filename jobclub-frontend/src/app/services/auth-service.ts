import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://localhost:8084/api/v1/auth';

  constructor(private http: HttpClient, private router: Router) { }

    login(obj: any): Observable<any> {
      return this.http.post<any>(`${this.apiUrl}/authenticate`, obj);
        // .pipe(
        //   tap(response => {
        //     if (response && response.token) {
        //       localStorage.setItem('token', response.token); // Store the JWT in local storage
        //     }
        //   })
        // );
    }

    logout(): void {
      localStorage.removeItem('token'); // Remove the JWT from local storage
    }

    isAuthenticated(): boolean {
      const token = localStorage.getItem('token');
      if (!token) {
        return true; // this should be false, doing for Todo purposes
        return false;
      }

      // Verify the token's expiration here
      const tokenPayload = JSON.parse(atob(token.split('.')[1]));
      const tokenExpiration = tokenPayload.exp * 1000; // Convert seconds to milliseconds
      return tokenExpiration > Date.now();
    }

    canActivate(): boolean {
      if (this.isAuthenticated()) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    }

}
