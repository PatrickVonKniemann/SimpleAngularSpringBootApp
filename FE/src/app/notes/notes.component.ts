import {Component, OnInit} from '@angular/core';
import {ApiService} from "../api.service";
import {Note} from "../note";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notes: Note[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getNotes().subscribe(data => {
      this.notes = data;
    });
  }
}
