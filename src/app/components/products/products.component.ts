import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/interface/Products';

import { ApiService } from 'src/app/services/api.service';
import { CartService } from 'src/app/services/cart.service';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  name!:string;
  productService:ProductsService;

  productname : any;
  productnum!: Array<any>;
  page: number = 0;
  pages!: Array<number>;
  posts: any;
  p: number = 1;
  prices: number[] = [];
  selectedPrice: number = 0;
  products: Products[] = [];
  public productList : any;

  ;
constructor(productService: ProductsService, private cartService: CartService){
  this.productService= productService
}


ngOnInit() {
  this.productService.getAllProducts()
  .subscribe((response)=>{
    this.productList=response;
    console.log(this.productList);
  },(error:any)=>{
    console.log(error)

  })

}

// ngOnInit(): void {
//   this.productService.getAllProducts().
//   subscribe((response)=>{
//   this.products = response;
//   console.log(this.products);

//   this.products.forEach(p => {
//     if(!this.prices.includes(p.price)){
//     this.prices.push(p.price);
//     }
//     });
//   },
//   (error: any)=>{console.log(error);},
//   ()=>{console.log("no further data");})

//   //this.getDataBySearch();
//   }

  // search products by name
  getDataBySearch(){

    this.productService.getSearchedData(this.productname)
    .subscribe((res: any) => {
      this.products = res;
      console.log(res);
   });
  }

  // filter data by price
  onSelectedPrice(selectedPrice:any):void{
    this.productService.getFilterDataByPrice(selectedPrice)
    .subscribe((data: Products[]) =>{
      this.products = data;
      data = this.products
            .filter(function (item, pos) {
            return data.indexOf(item) == pos;
        })
      console.log(data);
    })

   // console.log(this.selectedPrice);
  }

  // price in ascending order
  getFilteredDataAscending(){
    this.productService.getFilteredData()
    .subscribe((data: any) =>{
      //this.products = data;
      console.log(data);
    })
  }

  addtocart(item:Products){
   this.cartService.addtoCart(item);
   console.log(`Adding to cart: ${item.productname}, ${item.price}`);
  }

}




