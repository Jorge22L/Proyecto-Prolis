import { Component, OnInit } from '@angular/core';
import { Pais } from '../../interface/pais';
import { PaisService } from '../../services/pais.service';

@Component({
  selector: 'pais-main-page',
  templateUrl: './main-page.component.html',
  styles: [
  ]
})
export class MainPageComponent implements OnInit{
  public paises:Pais[] = [];

  constructor(private paisService:PaisService){}

  ngOnInit(): void {
    this.paisService.listarPaises().subscribe( response => this.listarPaises(response));
  }

  listarPaises(response: Pais[]){
    this.paises = response;
    console.log('response',response);
  }
}
