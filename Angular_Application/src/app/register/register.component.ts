
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public registerForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email:[''],
      firstname:[''],
      lastname:[''],
      password:[''],
      confirmPassword:['']
    })
  }
  register(){
    this.http.post<any>("http://localhost:8200/users/register",this.registerForm.value)
    .subscribe({ next:(res)=>{
      alert("Signup Successfully");
       this.registerForm.reset();
       this.router.navigate(['login']);
     },error:error=>{
         alert("Something went wrong");
     }
    })
  }
}