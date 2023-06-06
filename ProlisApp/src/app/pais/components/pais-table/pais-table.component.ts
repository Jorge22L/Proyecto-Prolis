import { Component, Input } from '@angular/core';
import { Pais } from '../../interface/pais';

@Component({
  selector: 'pais-table',
  templateUrl: './pais-table.component.html',
  styles: [
  ]
})
export class PaisTableComponent {
  @Input()
  public paises: Pais[] = [];

}
