import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotesComponent } from './notes/notes.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import {RouterLink} from "@angular/router";
import {AuthGuard} from "./auth.guard";

@NgModule({
  declarations: [
    AppComponent,
    NotesComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterLink
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
