import { Component, OnInit } from '@angular/core';
import { Products } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productname : any;
  productnum!: Array<any>;
  page: number = 0;
  pages!: Array<number>;
  posts: any;
  p: number = 1;
  prices: number[] = [];
  selectedPrice: number = 0;
  service: ProductService;
  products: Products[] = [];
  public productList : any;

  //public product:Array<Products> = [];

  constructor(service: ProductService) {
    this.service = service;
   }

   ngOnInit(): void {
    this.service.getAllProducts().
    subscribe((data)=>{
    this.products = data;
    console.log(this.products);

    this.products.forEach(p => {
      if(!this.prices.includes(p.price)){
      this.prices.push(p.price);
      }
      });
    },
    (error)=>{console.log(error);},
    ()=>{console.log("no further data");})

    //this.getDataBySearch();
    }

    // search products by name
    getDataBySearch(){

      this.service.getSearchedData(this.productname)
      .subscribe((res: any) => {
        this.products = res;
        console.log(res);
     });
    }

    // filter data by price
    onSelectedPrice(selectedPrice:any):void{
      this.service.getFilterDataByPrice(selectedPrice)
      .subscribe(data =>{
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
      this.service.getFilteredData()
      .subscribe(data =>{
        //this.products = data;
        console.log(data);
      })
    }
}
