import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TroupeComponent } from './troupe/troupe.component';
import { HireComponent } from './hire/hire.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TroupeComponent,
    HireComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
