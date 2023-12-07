import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthGuard} from "./auth.guard";
import {LoginComponent} from "./login/login.component";
import {RouterModule, Routes} from "@angular/router";
import {NotesComponent} from "./notes/notes.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'notes', component: NotesComponent, canActivate: [AuthGuard] },
  // ... other routes
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
