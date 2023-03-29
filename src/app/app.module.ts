import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { ProductService } from './service/product.service';
import { CategoryComponent } from './category/category.component';
import { ReviewComponent } from './review/review.component';
import { ProductlistComponent } from './products/productlist/productlist.component';
import { CategoryService } from './service/category.service';
import { CategoryItemComponent } from './category-item/category-item.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxPaginationModule } from 'ngx-pagination';
import { ReviewService } from './service/review.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CategoryComponent,
    ReviewComponent,
    ProductlistComponent,
    CategoryItemComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    NgxPaginationModule
  ],
  providers: [ProductService, CategoryService, ReviewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
