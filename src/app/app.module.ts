import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './components/cart/cart.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { ProductsComponent } from './components/products/products.component';
import { SuccessComponent } from './components/success/success.component';
import { CheckoutService } from './services/checkout.service';
import { OrderComponent } from './components/order/order.component';
import { CategoryComponent } from './components/category/category.component';
import { ReviewComponent } from './components/review/review.component';
import { ProductlistComponent } from './components/products/productlist/productlist.component';
import { CategoryItemComponent } from './components/category-item/category-item.component';
import { FooterComponent } from './components/footer/footer.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { CategoryService } from './services/category.service';
import { ProductsService } from './services/products.service';
import { ReviewService } from './services/review.service';



@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    ProductsComponent,
    SuccessComponent,
    CheckoutComponent,
    CartComponent,
    HeaderComponent,
    HomeComponent,
    OrderComponent,
    CategoryComponent,
    ReviewComponent,
    ProductlistComponent,
    CategoryItemComponent,
    FooterComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule

  ],
  providers: [
    ProductsService, CategoryService, ReviewService
  ],
  bootstrap: [AppComponent],
  exports:[


  ]
})
export class AppModule { }
