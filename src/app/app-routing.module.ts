import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryItemComponent } from './category-item/category-item.component';
import { CategoryComponent } from './category/category.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductlistComponent } from './products/productlist/productlist.component';
import { ProductsComponent } from './products/products.component';
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  {path: 'home' , component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path : 'menu', component: HomeComponent},
  {path : 'products', component: ProductsComponent},
  {path : 'products/:id', component: ProductlistComponent},
  {path : 'category', component: CategoryComponent},
  {path : 'category/:id', component: CategoryItemComponent},
  {path : 'reviews', component: ReviewComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  // {path: '**', component: PagenotfoundComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
