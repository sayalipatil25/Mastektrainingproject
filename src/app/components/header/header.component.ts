import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/interface/category';
import { CartService } from 'src/app/services/cart.service';
import { CategoryService } from 'src/app/services/category.service';
import { ProductsService } from 'src/app/services/products.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public totalItem: number=0;
  searchProductName : any;
  result:any = [];
  navbarOpen = false;

  categoryService: CategoryService;
  productService : ProductsService;
  category: Category[] = [];
  catData: any;

  constructor(private cartService: CartService, categoryService: CategoryService, productService: ProductsService)
  {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem=res.length;
    })

    this.categoryService.getAllCategory().
    subscribe((data)=>{
    this.category = data;
    console.log(this.category)},
    (error)=>{console.log(error);},
    ()=>{console.log("no further data");})

    this.getProductCatId();
  }

  getProductCatId(){
    this.categoryService.getAllCategory().subscribe((res) => {
      this.catData = res;
  })

  }

}
