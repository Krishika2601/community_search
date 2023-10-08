
/*
1. modules create
2. app.modules.ts--> import krane h-->module
3. routes->>path dena h
4. Declearation: module name
5. 




*/
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes,RouterModule } from '@angular/router'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { HomepageComponent } from './homepage/homepage.component';
import { PostReviewComponent } from './post-review/post-review.component';
import { ResultsPageComponent } from './results-page/results-page.component';
import { LandingPageComponent } from './landing-page/landing-page.component';

import { AdminComponent } from './admin/admin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { GetreviewComponent } from './getreview/getreview.component';


const routes: Routes =[

  {path:'homepage',component:HomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'results-page',component:ResultsPageComponent},
  {path:'post-review',component:PostReviewComponent},
  {path:'landing-page',component:LandingPageComponent},
  { path: "results-page/:search", component:ResultsPageComponent},
  {path:'admin',component:AdminComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'admin-main',component:AdminMainComponent},
  {path:'getreview',component:GetreviewComponent},
  { path: '**', redirectTo: 'homepage', pathMatch: 'full' }
];
@NgModule({
 
  
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginComponent,
    RegisterComponent,
    PostReviewComponent,
    ResultsPageComponent,
    LandingPageComponent,
    AdminComponent,
    AdminloginComponent,
    AdminMainComponent,
    GetreviewComponent,
    
   
  ],
  imports: [
    [RouterModule.forRoot(routes)],
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
  
})
export class AppModule { }