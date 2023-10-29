import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { EquipmentService } from './equipment.service';
import { TrainerService } from './trainer.service';


@Component({
  selector: 'app-slide',
  templateUrl: './slide.component.html',
  styleUrls: ['./slide.component.css']
})
export class SlideComponent implements OnInit {

  trainers: any[] = [];
  equipments: any[]= [];
  user: any;
  userEmail!: string;
  constructor(private trainerService: TrainerService,private equipmentService:EquipmentService,  private route: ActivatedRoute,
    private userService: UserService,) {

  }

  ngOnInit(): void {
    const userEmailParam = this.route.snapshot.paramMap.get('email');
    if (userEmailParam !== null ) {
      this.userEmail = userEmailParam;
      this.fetchUser();
    } else {
      // Handle the case where 'email' parameter is not present in the URL
      console.error('Email parameter is missing in the URL.');
    }
    this.trainerService.getAllTrainers().subscribe((data) => {
      this.trainers = data;
    });

    this.equipmentService.getAllEquipments().subscribe((data) => {
      this.equipments = data;
    });
  }

  fetchUser(): void {
    this.userService.getuserById(this.userEmail)
      .subscribe((user: any) => {
        this.user = user;
      });

      
  }

  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
  
  @HostListener('window:scroll', ['$event'])
  onScroll(event: Event): void {
    const scrollTop = window.scrollY || document.documentElement.scrollTop;
    const button = document.getElementById('scrollTopButton');
    if (button) {
      button.style.display = scrollTop > 20 ? 'block' : 'none';
    }
  }
}
