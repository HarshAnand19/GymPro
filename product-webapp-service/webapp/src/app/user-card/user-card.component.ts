import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { UserService } from '../user.service'; // Create a UserService to fetch user data
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent {
  @Input() userEmail!: string; 
  userData: any; 
  user!:any;
  property:boolean=true;
  constructor(private userService: UserService,private route: ActivatedRoute,private root:Router) {}
  ngOnInit(): void {
   
        
    const userEmailParam = this.route.snapshot.paramMap.get('email');
    if (userEmailParam !== null ) {
      this.userEmail = userEmailParam;
      this.fetchUser();
    } else {
      // Handle the case where 'email' parameter is not present in the URL
      console.error('Email parameter is missing in the URL.');
    }
  }
  
  
  fetchUser(): void {
    this.userService.getuserById(this.userEmail)
      .subscribe((user: any) => {
        this.user = user;
        console.log(user);
      });
  }
  direct(email:string){
    this.property=false;
    this.root.navigate(['app-update',email]);
    
  }
    
}
