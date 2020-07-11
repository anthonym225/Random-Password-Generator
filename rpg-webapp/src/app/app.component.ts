import { Component } from '@angular/core';
declare const type: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Random Password Generator';

  typeWriter() {
    type();
  }
}
