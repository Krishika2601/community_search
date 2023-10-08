import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SharedDataService } from '../shared-data.service';
import { Params } from '@angular/router';

@Component({
  selector: 'app-getreview',
  templateUrl: './getreview.component.html',
  styleUrls: ['./getreview.component.css']
})
export class GetreviewComponent implements OnInit {
  review:any[];
  constructor( private myService: SharedDataService, private formBuilder: FormBuilder, private http: HttpClient, private router:Router) {}

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8200/reviews")
    .subscribe(res => {
      this.review = res;
      
     console.log(this.review)
    });
  }

}
