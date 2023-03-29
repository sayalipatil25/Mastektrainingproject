import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
 template:`<div>
  <app-header></app-header>
  <app-products></app-products>
  </div>
  `

})
export class AppComponent {
  title = 'antique-store-app';
}
