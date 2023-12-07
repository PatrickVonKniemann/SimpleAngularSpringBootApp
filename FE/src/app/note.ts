export class Note {
  id: number;
  content: string;

  appUserId: number;

  constructor(id: number, content: string, appUserId: number) {
    this.id = id;
    this.content = content;
    this.appUserId = appUserId;
  }
}
