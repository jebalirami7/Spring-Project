import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/auth/generateToken`, credentials);
  }

  signup(credentials: any): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/auth/addnewuser`, credentials);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken() {
    return localStorage.getItem('token');
  }

  setToken(token: string) {
    localStorage.setItem('token', token);
  }

  logout() {
    localStorage.removeItem('token');
  }

  currentUser(): Observable<any> {
    return this.http.get(environment.apiURL + '/user/current');
  }
}
