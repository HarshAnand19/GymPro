import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  userEmail!: string;
  user: any;
  
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
  ) {}

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
      });

      
  }
}

