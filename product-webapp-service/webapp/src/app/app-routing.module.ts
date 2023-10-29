import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SlotAdminPanelComponent } from './slot-admin-panel/slot-admin-panel.component';
import { SlotBookComponent } from './slot-book/slot-book.component';
import { AdminSlotCreationComponent } from './admin-slot-creation/admin-slot-creation.component';

import { HomelanderComponent } from './homelander/homelander.component';
import { UsersComponent } from './users/users.component';
import { UpdateComponent } from './update/update.component';
import { UserCardComponent } from './user-card/user-card.component';
import { GymDetailsComponent } from './gym-details/gym-details.component';
import { TrainerComponent } from './trainers/trainers.component';
import { GymEqipmentsComponent } from './gym-eqipments/gym-eqipments.component';
import { GymDataComponent } from './gym-data/gym-data.component';
import { SubscriptionComponent } from './subscription/subscription.component';
import { PaymentComponent } from './payment/payment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { EventRegisterComponent } from './event-register/event-register.component';
import { EventListComponent } from './event-list/event-list.component';
import { CompetitionListComponent } from './competition-list/competition-list.component';
import { LoginComponent } from './login/login.component';
import { SlotBookingComponent } from './slot-booking/slot-booking.component';
import { ChatComponent } from './chat/chat.component';
import { MainComponent } from './main/main.component';
import { UserComponent } from './user/user.component';


const routes: Routes = [
  { path: '', component: HomelanderComponent }, 
  { path: 'admin/slotPanel', component: SlotAdminPanelComponent },
  { path: 'user-slot-booking', component: SlotBookComponent },
  { path: 'admin/slotCreation', component: AdminSlotCreationComponent },
  { path: 'log-in', component: LoginComponent },
  { path: 'registration', component: UsersComponent },
  {path: 'app-update',component: UpdateComponent },
  {path:'app-user-card/:email',component:UserCardComponent},
  { path: 'gymdetails', component: GymDetailsComponent },
  { path: 'trainers', component: TrainerComponent },
  { path: 'gymequipments', component: GymEqipmentsComponent },
  { path: 'gymdata', component: GymDataComponent },
  { path: 'subscription-service', component: SubscriptionComponent },
  { path: 'payment', component: PaymentComponent },
  {path: 'home-service/:email',component: HomePageComponent},
  { path: 'feedback', component: FeedbackComponent },
  { path: 'event-register', component: EventRegisterComponent },
  { path: 'event-list', component: EventListComponent },
  { path: 'event-participation', component: CompetitionListComponent},
  { path: 'slot-booked', component: SlotBookingComponent},
  { path: 'chat', component: ChatComponent },
  { path: 'users', component: UserComponent},
  { path: 'main', component: MainComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
