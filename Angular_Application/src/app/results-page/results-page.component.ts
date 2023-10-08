import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SharedDataService } from '../shared-data.service';
import { Params } from '@angular/router';

@Component({
  selector: 'app-results-page',
  templateUrl: './results-page.component.html',
  styleUrls: ['./results-page.component.css']
})
export class ResultsPageComponent implements OnInit {
products:any;
  constructor( private myService: SharedDataService, private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}
result1:any;
  posts:any;
  user:any[];
  product: any[];
  filteredUsers: any[];
  filterBy: any; 
  ngOnInit() {
    
   

     this.products = this.myService.data;
    console.log(this.products)
    console.log("Value of search",this.products)
    this.http.get<any>("http://localhost:8200/products")
    .subscribe(product => {
      this.product = product;
      this.filteredUsers = [...this.product];
      
     
    });
  }
    filter() {

      this.filteredUsers = [...this.product.filter(product => product.name.includes(this.products.search))];
      console.log(this.filteredUsers)
this.user=this.filteredUsers
    };
    
   
  
  

}
