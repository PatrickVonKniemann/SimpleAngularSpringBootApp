import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Note} from "./note";
import {AppUser} from "./app-user";


@Injectable({providedIn: 'root'})
export class ApiService {
  private apiUrl = 'http://localhost:8081'; // Your API URL

  constructor(private http: HttpClient) {
  }

  getNotes() {
    return this.http.get<Note[]>(`${this.apiUrl}/notes`);
  }

  getUsers() {
    return this.http.get<AppUser[]>(`${this.apiUrl}/users`);
  }
}


