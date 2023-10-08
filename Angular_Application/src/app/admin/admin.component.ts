
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public adminForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}
 

  ngOnInit(): void {
    this.adminForm = this.formBuilder.group({
      id:1,
      name:[''],
      productcode:[''],
      brand:['']
     
    })
  }
  admin(){
    this.http.post<any>("http://localhost:8200/products",this.adminForm.value)
    .subscribe({ next:(res)=>{
      alert("New Products are Added !!");
      this.adminForm.reset();
      console.log(this.adminForm.value) 
     
    }
  })
}
}