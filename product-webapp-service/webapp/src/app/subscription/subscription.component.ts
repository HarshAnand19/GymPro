import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { PackService } from '../pack.service';
import { SubscriptionService } from './subscription.service';

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit{
  subscriptions: any[] = [];
  // @Input() userEmail!: string;
  
  // emailUser!: string;

  userEmail!: string;
  firstName!: string;
  phone!: string;

  constructor(public pac:PackService,private route: ActivatedRoute,private router: Router,private subscriptionService: SubscriptionService,private dataService: DataService) {
    
  }

  
  ngOnInit(): void {
    // if(this.emailUser == null){
    //   console.log('error');
    // }
    // this.emailUser = this.dataService.getUserEmail();
    const emailParam = this.route.snapshot.queryParamMap.get('email');
   const nameParam = this.route.snapshot.queryParamMap.get('firstName');
    const phoneParam = this.route.snapshot.queryParamMap.get('phone');
    if (emailParam !== null && nameParam!=null  && phoneParam!=null) {
      this.userEmail = emailParam;
      this.firstName=nameParam;
      this.phone=phoneParam;
    } else {
console.log(' error')
    }

    this.subscriptionService.getAllSubscriptions().subscribe(
      (data) => {
        this.subscriptions = data;
     
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
  Buy(subscription: any) {
    // Pass data to the service
    this.dataService.setCardData(
      subscription.subscriptionName,
      subscription.subscriptionDetails,
      subscription.subscriptionPrice.toString()
    );
  
    // Pass email, phone, and name as query parameters to the Payment component
    this.router.navigate(['/payment'], {
      queryParams: {
        email: this.userEmail,
        name: this.firstName,
        phone: this.phone,     
      },
    });
  }
  
}
