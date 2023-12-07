import {Note} from "./note";

export class AppUser {
  id: number;
  name: string;
  notes: Note[];

  constructor(id: number, name: string, notes: Note[]) {
    this.id = id;
    this.name = name;
    this.notes = notes;
  }

}
