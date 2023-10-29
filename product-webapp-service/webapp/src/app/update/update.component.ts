import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UpdateserviceService } from '../updateservice.service';
import { User } from '../user.model';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  profileForm!: FormGroup;
  selectedFile: any;
  user!: User;

  constructor(
    private formBuilder: FormBuilder,
    private api: UpdateserviceService,
    private route: ActivatedRoute,
    private userService: UserService
  ) {}

  ngOnInit() {
    // Retrieve the email parameter from the URL
    this.route.params.subscribe((params) => {
      const email = params['email'];
      // Fetch user data based on the email
      this.userService.getuserById(email).subscribe((userData: User) => {
        this.user = userData;
        // Initialize the profileForm with user data
        this.profileForm = this.formBuilder.group({
          profilePicturePath: [''],
          firstName: [userData.firstName, Validators.required],
          lastName: [userData.lastName, Validators.required],
          email: [userData.email, Validators.required],
          phone: [userData.phone, Validators.required],
          age: [userData.age, Validators.required],
          gender: [userData.gender, Validators.required],
          weight: [userData.weight, Validators.required],
          height: [userData.height, Validators.required],
          address: [userData.address, Validators.required]
        });
      });
    });
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.profileForm.get('profilePicturePath')!.setValue(file);
    }
  }

  updateProfile() {
    if (this.profileForm && this.profileForm.valid) {
      console.log('Updating profile...', this.profileForm.value);
      const email = this.profileForm.value.email;
      // Create a User object with updated data
      const updatedUser = new User(
        this.profileForm.value.firstName,
        this.profileForm.value.lastName,
        this.profileForm.value.email,
        this.profileForm.value.phone,
        this.profileForm.value.age,
        this.profileForm.value.address,
        this.profileForm.value.height,
        this.profileForm.value.gender,
        this.profileForm.value.weight
      );
      const profilePictureControl = this.profileForm.get('profilePicturePath');
      if (profilePictureControl) {
        this.api.updateUser(email, updatedUser, this.profileForm.value.profilePicturePath).subscribe((res) => {
          console.log(res);
        });
      }
    }
  }

  isFieldInvalid(fieldName: string) {
    const control = this.profileForm.get(fieldName);
    return control !== null && control.invalid && (control.dirty || control.touched);
  }
}