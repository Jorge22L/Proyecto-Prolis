import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pais } from '../interface/pais';

@Injectable({providedIn: 'root'})
export class PaisService {
  private apiUrl: string = "http://localhost:8082/api/pais";

  constructor(private http: HttpClient) { }

  listarPaises():Observable<Pais[]>{
    console.log('funciona');
    return this.http.get<Pais[]>(this.apiUrl);
  }

}
