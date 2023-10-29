import { Component, OnInit } from '@angular/core';
import { CompetitionService } from '../competition.service';

@Component({
  selector: 'app-competition-list',
  templateUrl: './competition-list.component.html',
  styleUrls: ['./competition-list.component.css']
})
export class CompetitionListComponent implements OnInit {
  competitions: any[] = [];

  constructor(private competitionService: CompetitionService) { }

  ngOnInit(): void {
    this.competitionService.getCompetitionData('abc@gmail.com',).subscribe(data => {
      this.competitions = data as any[];
      console.log(this.competitions);
    });
  }
}
