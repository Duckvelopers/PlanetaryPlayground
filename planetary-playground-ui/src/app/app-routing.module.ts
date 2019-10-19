import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanetaryOverviewComponent } from './planetary-overview/planetary-overview.component';


const routes: Routes = [
  { path: '', redirectTo: '/planetary', pathMatch: 'full' }, 
  { path: 'planetary', component: PlanetaryOverviewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
