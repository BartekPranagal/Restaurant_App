import {Component, OnInit,} from '@angular/core';
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  constructor(private loginService: LoginService) { }


  ngOnInit(): void {

  }

  goTo(location: string): void {
    window.location.hash = '';
    window.location.hash = location;
  }
  goToPlusScroll(location: string): void {
    window.location.hash = '';
    window.location.hash = location;
    window.scrollBy({top: -100})
  }

  isLoggedIn(): boolean {
    return this.loginService.loggedIn
}

  admin(): boolean {
    return this.loginService.authorities.includes('ROLE_ADMIN')
  }

  user(): boolean {
    return this.loginService.authorities.includes('ROLE_USER')
  }

}
