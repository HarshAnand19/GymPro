import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gym-data',
  templateUrl: './gym-data.component.html',
  styleUrls: ['./gym-data.component.css']
})
export class GymDataComponent {
  constructor(private router: Router) { }
}
