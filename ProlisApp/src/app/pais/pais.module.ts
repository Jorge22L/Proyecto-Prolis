import { NgModule } from '@angular/core';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { PaisTableComponent } from './components/pais-table/pais-table.component';
import { CommonModule } from '@angular/common';


@NgModule({
  imports: [
    CommonModule
  ],
  exports: [
    MainPageComponent
  ],
  declarations: [
    MainPageComponent,
    PaisTableComponent
  ],
  providers: [],
})
export class PaisModule { }
