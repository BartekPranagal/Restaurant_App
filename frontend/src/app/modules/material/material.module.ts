import { NgModule } from '@angular/core';

import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatListModule} from '@angular/material/list';

const MATERIAL_MODULES: any = [
  MatCardModule,
  MatToolbarModule,
  MatIconModule,
  MatButtonModule,
  MatInputModule,
  MatButtonToggleModule,
  MatSelectModule,
  MatListModule
];

@NgModule({
  exports: [
    MATERIAL_MODULES
  ],
  imports: [
    MATERIAL_MODULES
  ]
})
export class MaterialModule { }
