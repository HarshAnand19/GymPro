import { Component, HostListener, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderServiceService } from './order-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PackService } from '../pack.service';
import { DataService } from '../data.service';
import { SubscriptionupdateService } from '../subscriptionupdate.service';

declare var Razorpay: any;
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {


  cardTitle: string = '';
  cardText: string = '';
  cardBasic: string = '';
  // userEmail: string = 'rishi@gmail.com'; 

  userEmail!: string;
  firstName!: string;
 userPhone!: string;

  price!: any;

 title = 'demo';

  form: any = {
    
    amount:3000
  }; 
  constructor(private http: HttpClient,
    private orderService:OrderServiceService,
    private route: ActivatedRoute,
    private dataService: DataService,
    public pac:PackService,
    private router: Router,
    private subscriptionUpdateService: SubscriptionupdateService 
    ) {

  }

  
  ngOnInit():void {

    const emailParam = this.route.snapshot.queryParamMap.get('email');
    const nameParam = this.route.snapshot.queryParamMap.get('name');
     const phoneParam = this.route.snapshot.queryParamMap.get('phone');
     if (emailParam !== null && nameParam!=null  && phoneParam!=null) {
       this.userEmail = emailParam;
       this.firstName=nameParam;
       this.userPhone=phoneParam;

       console.log('User Phone:', this.userPhone);
       console.log('Email:', this.userEmail);
       console.log('Name:', this.firstName);

     } else {
 console.log(' error')
     }


    this.dataService.cardTitle$.subscribe(title => {
      console.log('Received cardTitle:', title);
      this.cardTitle = title;
    });
    
    this.dataService.cardText$.subscribe(text => {
      console.log('Received cardText:', text);
      this.cardText = text;
    });
    
    this.dataService.cardBasic$.subscribe(basic => {
      console.log('Received cardBasic:', basic);
      this.cardBasic = basic;
    });
    

    // this.route.params.subscribe(params => {
    //   this.cardTitle = params['cardTitle'];
    //   this.cardText = params['cardText'];
    //    this.cardBasic = params['cardBasic'];

      if (this.cardTitle === 'Basic Plan') {
        this.form.amount = 1000;
         this.cardText = this.pac.gymNa.replace(/(\d+\))/g, '<br>$1'); 
      } else if (this.cardTitle === 'Pro Plan') {
        this.form.amount = 3000;
         this.cardText = this.pac.crossFitness.replace(/(\d+\))/g, '<br>$1');
      } else if (this.cardTitle === 'Elite Plan') {
        this.form.amount = 5000;
         this.cardText = this.pac.kickBoxing.replace(/(\d+\))/g, '<br>$1');
      }

    // });

  }

  sayHello() {
    alert("Hello DK");
  }

  paymentId!: string;
  error!: string;
  
  options = {
    "key": "",
    "amount": "", 
    "name": "GymPro",
    "description": "GymPro",
    "image": "https://www.javachinna.com/wp-content/uploads/2020/02/android-chrome-512x512-1.png",
    "order_id":"",
    "handler": function (response: any){
      var event = new CustomEvent("payment.success", 
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );	  
      window.dispatchEvent(event);
    }
    ,
    "prefill": {
    "name": "",
    "email": "",
    "contact": ""
    },
    "notes": {
    "address": ""
    },
    "theme": {
    "color": "#3399cc"
    }
    };
  
    onSubmit(): void {
      this.paymentId = ''; 
      this.error = ''; 
      this.orderService.createOrder(this.form).subscribe(
      data => {
        this.options.key = data.secretId;
        this.options.order_id = data.razorpayOrderId;
        this.options.amount = data.applicationFee; //paise
        this.options.prefill.name = "GymPro";
        this.options.prefill.email = "";
        this.options.prefill.contact = "";
        
        if(data.pgName ==='razor2') {
          this.options.image="";
          var rzp1 = new Razorpay(this.options);
          rzp1.open();
        } else {
          var rzp2 = new Razorpay(this.options);
          rzp2.open();
        }
       
                
        rzp1.on('payment.failed', (response: any) => {
          // Now TypeScript knows the expected type of 'response'
          console.log(response);
          console.log(response.error.code);
          console.log(response.error.description);
          console.log(response.error.source);
          console.log(response.error.step);
          console.log(response.error.reason);
          console.log(response.error.metadata.order_id);
          console.log(response.error.metadata.payment_id);
          this.error = response.error.reason;
        });
        
      }
      ,
      err => {
        this.error = err.error.message;
      }
      );
    }

    // @HostListener('window:payment.success', ['$event']) 
    // onPaymentSuccess(event: { detail: any; }): void {
    //    console.log(event.detail);
    //    this.router.navigate(['/subscription-service']);
    // }

    // payment.component.ts

// Import the SubscriptionUpdateService

@HostListener('window:payment.success', ['$event'])
onPaymentSuccess(event: { detail: any; }): void {
  console.log(event.detail);


  const userEmail = this.userEmail;
  const subscriptionTitle = this.cardTitle;

  // Call the service to update the subscription
  this.subscriptionUpdateService.updateSubscription(userEmail, subscriptionTitle)
    .subscribe(
      (response) => {
        console.log('Subscription updated successfully', response);

        this.router.navigate(['/subscription-service']);
      },
      (error) => {
        console.error('Error updating subscription', error);

      }
    );
}


}