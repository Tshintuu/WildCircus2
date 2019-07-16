import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TroupeComponent } from './troupe/troupe.component';
import { HireComponent } from './hire/hire.component';

const appRoutes: Routes = [
  {
    path: "",
    component: LoginComponent,
    pathMatch: "full"
  },
  {
    path: "troupe",
    component: TroupeComponent,
    pathMatch: "full"
  },
  {
    path: "hire",
    component: HireComponent,
    pathMatch: "full"
  }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TroupeComponent,
    HireComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
