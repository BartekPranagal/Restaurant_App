import {Component, OnInit} from '@angular/core';
import {User} from "../../../models/User";
import {LoginService} from "../../../services/login.service";
import {EditServiceService} from "../../../services/edit-service.service";
import {Order} from "../../../models/Order";
import {OrdersService} from "../../../services/orders.service";
import {BackupService} from "../../../services/backup.service";

@Component({
  selector: 'app-admin-main',
  templateUrl: './admin-main.component.html',
  styleUrls: ['./admin-main.component.css']
})
export class AdminMainComponent implements OnInit {

  users!: User[];
  orders!: Order[];
  file: File = null;
  loading: boolean = false; // Flag variable
  success: boolean = false;

  constructor(private loginService: LoginService, private editService: EditServiceService,
              private orderService: OrdersService, private backupService: BackupService) {

    loginService.users().subscribe(data => this.users = data)
    orderService.allOrders().subscribe(data => {
      this.orders = data
      console.log(data)
    })
  }

  ngOnInit(): void {
  }

  onChange(event) {
    this.file = event.target.files[0];
    this.success = false;
  }

  setId(x: number): void {
    this.editService.id = x;
  }

  downloadDatabaseContent(fileFormat: string) {
    this.backupService.download(fileFormat);
  }

  onUpload() {
    if(this.file == null){
      return;
    }
    this.loading = true;
    this.backupService.upload(this.file).subscribe((event: any) => {
      if (typeof (event) === 'object') {
        this.loading = false;
        this.success = true;
      }
    })
  }
}
