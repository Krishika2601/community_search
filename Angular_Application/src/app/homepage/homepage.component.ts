import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
countProduct:any;
countReviews:any;
countUsers:any;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get("http://localhost:8200/stats/product" , {responseType:"text"})
    .subscribe(res => {
      this.countProduct = res;
     
     
    });
    this.http.get("http://localhost:8200/stats/reviews", {responseType:"text"})
    .subscribe(res => {
      this.countReviews = res;
     
    });
    this.http.get("http://localhost:8200/stats/users", {responseType:"text"})
    .subscribe(res => {
      this.countUsers = res;
     
    });
  }

}
