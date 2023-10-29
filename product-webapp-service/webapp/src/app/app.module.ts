import { NgModule,OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminSlotCreationComponent } from './admin-slot-creation/admin-slot-creation.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SlotService } from './slot.service';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { SlotBookComponent } from './slot-book/slot-book.component';
import { SlotAdminPanelComponent } from './slot-admin-panel/slot-admin-panel.component';
import { UpdateSlotModalComponent } from './update-slot-modal/update-slot-modal.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { HomelanderComponent } from './homelander/homelander.component';
import { FeedbackService } from './feedback.service';
import { UsersComponent } from './users/users.component';
import { UserService } from './user.service';
import { UpdateComponent } from './update/update.component';
import { UserCardComponent } from './user-card/user-card.component';
import { RegistrationserviceService } from './registrationservice.service';
import { UpdateserviceService } from './updateservice.service';
import { GymDataComponent } from './gym-data/gym-data.component';
import { TrainerComponent } from './trainers/trainers.component';
import { GymDetailsComponent } from './gym-details/gym-details.component';
import { GymEqipmentsComponent } from './gym-eqipments/gym-eqipments.component';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatToolbarModule } from '@angular/material/toolbar';
import { PaymentComponent } from './payment/payment.component';
import { SubscriptionComponent } from './subscription/subscription.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SlideComponent } from './slide/slide.component';
import { HomePageComponent } from './home-page/home-page.component';
import { PackService } from './pack.service';
import { SubscriptionupdateService } from './subscriptionupdate.service';
import { DataService } from './data.service';
import { EventRegisterComponent } from './event-register/event-register.component';
import { EventListComponent } from './event-list/event-list.component';
import { EventService } from './event.service';
import { CompetitionListComponent } from './competition-list/competition-list.component';
import { CompetitionService } from './competition.service';
import { AuthserviceService } from './authservice.service';
import { SlotBookingComponent } from './slot-booking/slot-booking.component';
import { SlotBookingService } from './slot-booking.service';
import { UserComponent } from './user/user.component';
import { MainComponent } from './main/main.component';
import { ChatComponent } from './chat/chat.component';
import { ChatService } from './services/chat.service';



@NgModule({
    declarations: [
        AppComponent,
        AdminSlotCreationComponent,
        SlotBookComponent,
        SlotAdminPanelComponent,
        UpdateSlotModalComponent,
        LoginComponent,
        HomelanderComponent,
        UsersComponent,
        UpdateComponent,
        UserCardComponent,
        GymDataComponent,
        TrainerComponent,
        GymDetailsComponent,
        GymEqipmentsComponent,
        ConfirmationDialogComponent,
        PaymentComponent,
        SubscriptionComponent,
        HeaderComponent,
        FooterComponent,
        FeedbackComponent,
        SlideComponent,
        HomePageComponent,
        EventRegisterComponent,
        EventListComponent,
        CompetitionListComponent,
        SlotBookingComponent,
        UserComponent,
        MainComponent,
        ChatComponent
        
    ],
    providers: [SlotService, DatePipe, FeedbackService,UserService,RegistrationserviceService,UpdateserviceService,PackService,FeedbackService, SubscriptionupdateService, DataService, EventService, CompetitionService, AuthserviceService,
    SlotBookingService, ChatService, UserService ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        DatePipe,
        NgbModule,
        ReactiveFormsModule,
        MatToolbarModule,
        MatIconModule,
        MatDialogModule
        
        
    ]
})
export class AppModule { }
