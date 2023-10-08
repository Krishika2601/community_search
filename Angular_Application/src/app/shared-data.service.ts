import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SharedDataService {
  sharedValue$ = new Subject();
  data=[];
  Userdetails=[];
  emailid=[];
  constructor() { }
}
