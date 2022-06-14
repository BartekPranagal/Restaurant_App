import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {JwtHelperService} from "@auth0/angular-jwt";
import {User} from "../models/User";
import {map, Observable} from "rxjs";
import * as FileSaver from "file-saver";
import {FileSaverService} from "ngx-filesaver";
import {LoginService} from "./login.service";

@Injectable({
  providedIn: 'root'
})
export class BackupService {

  private downloadUrl = 'http://localhost:8080/api/backup?format='
  private uploadUrl = 'http://localhost:8080/api/backup';

  constructor(private httpClient: HttpClient,
              private router: Router,
              private filesSaver: FileSaverService,
              private loginService: LoginService) {

  }

  download(fileFormat: string): void {
    this.httpClient.get<Blob>(this.downloadUrl + fileFormat, {
      observe: 'response', responseType: 'blob' as 'json',
      headers : new HttpHeaders({
        'Authorization': 'Bearer ' + this.loginService.token
      })
    }).pipe(map((result:HttpResponse<Blob>) => {
      this.filesSaver.save(result.body, "export." + fileFormat);
    })).subscribe();
  }

  upload(file): Observable<any> {
    const formData = new FormData();
    formData.append("file", file, file.name);
    return this.httpClient.post(this.uploadUrl, formData, {
      headers : new HttpHeaders({
        'Authorization': 'Bearer ' + this.loginService.token
      })
    });
  }

}
