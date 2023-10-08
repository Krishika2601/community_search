import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SharedDataService } from '../shared-data.service';
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  public AdminForm !: FormGroup;
  constructor(private myservice : SharedDataService, private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}
 
  

  ngOnInit(): void {
    this.AdminForm=this.formBuilder.group({
      email:[''],
      password:['']
    })
  }
  adminlogin(){
 

    this.http.post<any>("http://localhost:8200/admin/login",this.AdminForm.value)
    .subscribe(res=>{
      const Admin=res;
    if(Admin=="SUCCESS"){
     
      
     
      alert(" Admin Login Success!!");
      
      this.router.navigate(['admin-main'])
    }else{
      alert("Admin not found!!");
    }
    },err=>{
      alert("Something went wrong!!");
    })
      }
}
