import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-post-review',
  templateUrl: './post-review.component.html',
  styleUrls: ['./post-review.component.css']
})
export class PostReviewComponent implements OnInit {
  public reviewForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      rating:[''],
      review:[''],
      product:[''],
      brand:['']
    })
  }
  review(){
    this.http.post<any>("http://localhost:8200/review/product",this.reviewForm.value)
    .subscribe({ next:(res)=>{

      alert("Review Submitted !!");
       this.reviewForm.reset();
        
     }
    })
  
}}

  
