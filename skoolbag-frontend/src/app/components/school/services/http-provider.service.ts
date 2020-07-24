import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class HttpProviderService {

  baseUrl: string = environment.backend.baseURL;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) { }

  public getForObject(url: string): Observable<any> {
    return this.httpClient.get(this.baseUrl + url, this.httpOptions);
  }

  public postForObject(url: string, obj: any): Observable<any> {
    return this.httpClient.post(this.baseUrl + url, obj, this.httpOptions);
  }
}
