import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'; // Import FormBuilder and FormGroup
import { RegistrationserviceService } from '../registrationservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UpdateComponent } from '../update/update.component';
import { UserService } from '../user.service';
import { User } from '../user.model';
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']  
})
export class UsersComponent implements OnInit { // Implement OnInit

  userForm!: FormGroup;
  showUsersTemplate: boolean = true; // Define a FormGroup
  email:any;
  userData!: User;
  constructor(
    private api: RegistrationserviceService,
    private formBuilder: FormBuilder, // Inject FormBuilder
    private router: Router,
    private route: ActivatedRoute,
    private root:UserService
  ) {}

  ngOnInit() {
    this.email=this.route.snapshot.paramMap.get('email');
this.root.getuserById(this.email).subscribe((res)=>{
  this.userData=res;
  console.log(res);
    })
    this.userForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.pattern('^[A-Za-z]+$')]],
      lastName: ['', [Validators.required, Validators.pattern('^[A-Za-z]+$')]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required], 
      password: ['', Validators.required], 
      role: ['', Validators.required],
      
      
  })
}

  postDetails() {
    if (this.userForm.valid) { 
      const user = this.userForm.value; 
      if (user.role === 'user') {
        this.api.postuser(user).subscribe((res) => {
          console.log(res); 
          this.router.navigate(['/login']);
          
        });
      } else {
        this.api.postadmin(user).subscribe((res) => {
          console.log(res);  
           
        });
      }
    }
  }
  btnclick(email:string){
    this.showUsersTemplate=false;
    const user = this.userForm.value;
    this.router.navigate(['app-update', email]);
    
}
// showclick(){
  
//   if (this.userForm.valid) {
//     this.showUsersTemplate=false;
//     const email = this.userForm.get('email')?.value; // Get the email from the form
//     this.router.navigate(['app-user-card', email]); // Navigate to the app-user-card route with the email parameter
    
// }
// }

}
