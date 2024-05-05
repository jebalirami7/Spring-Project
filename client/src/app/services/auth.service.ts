import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { JwtHelperService } from '@auth0/angular-jwt';
import { get } from 'jquery';
import { User } from '../entities/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/user/login`, credentials);
  }

  signup(credentials: any): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/user`, credentials);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string {
    return localStorage.getItem('token') || '';
  }

  setToken(token: string) {
    localStorage.setItem('token', token);
  }

  refreshToken(): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/user/refresh-token`, {});
  }

  logout() {
    localStorage.removeItem('token');
  }

  currentUser(token: string = this.getToken()): any {
    const helper = new JwtHelperService();
    const decoded= helper.decodeToken(token);
    return decoded;
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${environment.apiURL}/user/${id}`);
  }

  updateUser(id: number, data: User): Observable<User> {
    return this.http.put<User>(`${environment.apiURL}/user/${id}`, data);
  }

  checkTokenExpiration(): boolean {
    const helper = new JwtHelperService();
    const token = this.getToken();
    return helper.isTokenExpired(token);
  }
}
