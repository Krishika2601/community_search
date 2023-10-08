import { Component, OnInit } from '@angular/core';
import { SharedDataService } from '../shared-data.service';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {
  public landingPage !: FormGroup;
  constructor(private formBuilder: FormBuilder ,private myService: SharedDataService ,public route: Router) { }
 search:any;
 username:any;
  ngOnInit() {
    this.landingPage = this.formBuilder.group({
      search:[''],

    })
    this.Userfunction()
   
  
  }
  Userfunction(){
    console.log(this.myService.Userdetails)
    for(let i = 0; i < this.myService.Userdetails.length; i++) {
      if(this.myService.Userdetails[i]['email']==this.myService.emailid){
        console.log("Hi "+this.myService.Userdetails[i]['firstname']+" , how are you")
        this.username=this.myService.Userdetails[i]['firstname']
      }
   
}
  }
  Submit(){
    const x=this.landingPage.value;
    console.log(x)
    this.myService.data=x;
   
    
    console.log(this.myService.data)
    this.route.navigate(['/results-page']);

  }

}
