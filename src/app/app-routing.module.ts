import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { CategoryItemComponent } from './components/category-item/category-item.component';
import { CategoryComponent } from './components/category/category.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { HomeComponent } from './components/home/home.component';
import { OrderComponent } from './components/order/order.component';
import { ProductlistComponent } from './components/products/productlist/productlist.component';
import { ProductsComponent } from './components/products/products.component';
import { ReviewComponent } from './components/review/review.component';
import { SuccessComponent } from './components/success/success.component';

const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'products', component:ProductsComponent},
{path:'cart', component:CartComponent},
{path : 'menu', component: HomeComponent},
{path:'address', component:CheckoutComponent},
{path: 'home', component:HomeComponent},
{path: 'success', component:SuccessComponent},
{path:'orders', component:OrderComponent},
{path:'checkout', component:CheckoutComponent},
{path : 'products/:id', component:ProductlistComponent},
{path : 'category', component: CategoryComponent},
{path : 'category/:id', component: CategoryItemComponent},
{path : 'reviews', component: ReviewComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
