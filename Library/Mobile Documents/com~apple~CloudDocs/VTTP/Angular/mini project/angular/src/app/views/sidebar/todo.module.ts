import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CardModule, GridModule, NavModule, UtilitiesModule, TabsModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { AgmCoreModule } from '@agm/core';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { NavigationComponent } from './navigation.component';
import { NotesComponent } from './notes.component';
import { ScheduleComponent } from './schedule.component';
import { UserComponent } from './user.component';

// Todo Routing
import { TodoRoutingModule } from './todo-routing.module';

@NgModule({
  imports: [
    CommonModule,
    TodoRoutingModule,
    CardModule,
    GridModule,
    UtilitiesModule,
    NgbModalModule,
    IconModule,
    NavModule,
    FormsModule,
    ReactiveFormsModule,
    TabsModule,
    FlatpickrModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDSz1URB-persd6libOizUypydNUMx6tM4'
    }),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
  ],
  declarations: [
    UserComponent,
    ScheduleComponent,
    NotesComponent,
    NavigationComponent,
  ]
})
export class TodoModule {
}
