import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule, Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { DonorComponent } from './components/donor/donor.component';
import { HeaderComponent } from './components/header/header.component';
import { BorrowerComponent } from './components/borrower/borrower.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomeComponent },
  { path: 'donor', component: DonorComponent },
  { path: '', component: WelcomeComponent, pathMatch: 'full' },
  { path: '**', component: WelcomeComponent, pathMatch: 'full' },
];
@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    DonorComponent,
    HeaderComponent,
    BorrowerComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
