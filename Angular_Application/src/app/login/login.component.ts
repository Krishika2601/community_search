import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SharedDataService } from '../shared-data.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public LoginForm !: FormGroup;
  constructor(private myservice : SharedDataService, private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}
  ngOnInit(): void {
    this.LoginForm=this.formBuilder.group({
      email:[''],
      password:['']
    })
  }


login(){
 

  this.http.post<any>("http://localhost:8200/users/login",this.LoginForm.value)
  .subscribe(res=>{
    const User=res;
  if(User=="SUCCESS"){
    this.http.get<any>("http://localhost:8200/users")
    .subscribe(res => {
      const x= res;
      this.myservice.Userdetails = x;
     this.myservice.emailid=this.LoginForm.value.email;
    //  if(this.LoginForm.value.email==x)
       console.log( "inside api",this.myservice.Userdetails)
      
     
    });
    
    console.log("outside",this.myservice.Userdetails)
    alert("Login Success!!");
    
    this.router.navigate(['landing-page'])
  }else{
    alert("user not found!!");
  }
  },err=>{
    alert("Something went wrong!!");
  })
    }
  }
  
  
