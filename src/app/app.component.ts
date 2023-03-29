import { Component } from '@angular/core';
import { Category } from './model/category';
import { CategoryService } from './service/category.service';
import { ProductService } from './service/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'antique-store-frontend';


  searchProductName : any;
  result:any = [];
  navbarOpen = false;
  public totalItem: number=0;

  service: CategoryService;
  proService : ProductService;
  category: Category[] = [];
  catData: any;

  //public product:Array<Products> = [];

  constructor(categoryService: CategoryService, productService: ProductService) {
    this.service = categoryService;
    this.proService = productService;
   }

  ngOnInit(): void {
    this.service.getAllCategory().
    subscribe((data)=>{
    this.category = data;
    console.log(this.category)},
    (error)=>{console.log(error);},
    ()=>{console.log("no further data");})

    this.getProductCatId();

    // this.cartService.getProducts()
    // .subscribe(res=>{
    //   this.totalItem=res.length;
    // })
  }

  getProductCatId(){
    this.service.getAllCategory().subscribe((res) => {
      this.catData = res;
  })

  }

}
