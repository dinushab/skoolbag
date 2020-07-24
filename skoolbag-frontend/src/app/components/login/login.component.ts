// import { Component, OnInit } from '@angular/core';
// import { AuthService } from '../../services/auth.service';
// import {LoginInfo} from '../../models/LoginInfo';
// import {JwtResponse} from '../../models/JwtResponse';
// import { UserService } from '../../services/user.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent implements OnInit {

//   username: string = '';
//   password: string = '';
//   isLoggedIn: boolean = false;
//   loginInfo: LoginInfo;

//   constructor(private authService: AuthService, private loginService: UserService, private router: Router) { }

//   ngOnInit(): void {
//     if(this.authService.getToken()) {
//       this.isLoggedIn = true;
//     }
//   }

//   login() {
//     this.loginInfo = new LoginInfo(
//       this.username,
//       this.password
//     );
//     this.loginService.login(this.loginInfo).subscribe((response: JwtResponse) => {
//       this.authService.saveToken(response.accessToken);
//       this.router.navigate(['list']);
//     });
//   }

// }
