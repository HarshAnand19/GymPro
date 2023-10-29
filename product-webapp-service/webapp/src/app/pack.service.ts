import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PackService {
  packname="";
  packdesc="";
  accountStatus="Inactive";

  gyM="Basic Plan";
  gymNa="Plan Benefits : <br> 1) Workout Schedule <br> 2) Calorie tracking <br> 3) Diet Plan"
  basicprice="1000"

  crossFi="Pro Plan";
  crossFitness="Plan Benefits : <br> 1) Weekly and Monthly Tracking <br> 2) Macros and micros tracking <br> 3) Customized Diet Chart"
  proprice="3000"

  kickBo="Elite Plan";
  kickBoxing="Plan Benefits : <br> 1) Personal Mentorship from trainers <br> 2) Dedicated Fitness Coach <br> 3) Personalized Fitness Plan"
  eliteprice="5000"

  stbath=1000;
  pt=2000;
  dplan=500;
  name=localStorage.getItem("loggedusername");
  namee=localStorage.getItem("loggedusernamee");
  gender=localStorage.getItem("loggedusergen");
  age=localStorage.getItem("loggeduserage");
  

  constructor(public http:HttpClient,public router: Router) { 
    console.log("service created");
  }
  gymBuy(){
    this.router.navigate(['/payment-service', this.gyM, this.gymNa,this.basicprice]);
  }
  crossBuy(){
    this.router.navigate(['/payment-service', this.crossFi, this.crossFitness,this.proprice]);
  }
  kickBuy(){
    this.router.navigate(['/payment-service', this.kickBo, this.kickBoxing,this.eliteprice]);
  }
  }
 
