import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Products } from '../model/product';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  http:HttpClient;
  products: Products[] = [];
  baseUrl = "http://localhost:8080/api/v2/";


  constructor(http: HttpClient) {
    this.http = http;
   }

   // to fetch all products
   public getAllProducts(){

    let x: Observable<Products[]>;
    x = this.http.get<Products[]>("http://localhost:8080/api/v2/products");
    return x;
   }

   // get product by ID
   public getProduct(id: number){
    let x: Observable<Products>;
    x = this.http.get<Products>("http://localhost:8080/api/v2/products/" + id);
    return x;
  }

  // get product by Category Id
  public getProductByCategoryId(id: number){

    let x: Observable<Category>;
    x = this.http.get<Category>("http://localhost:8080/api/v1/category/" + id);
    return x;
  }

  // pagination
   getProductListPaginate(pgnum: number, size: number){
   return this.http.get("http://localhost:8080/api/v2/page/products?pgnum=" + pgnum + '&size=' + size);
  }

      // search products
      getSearchedData(value : string){
        return this.http.get("http://localhost:8080/api/v2/search?key=" + value);
      }

      // filter the data
      getFilterDataByPrice(price: number): Observable<any>{
        let param1 = new HttpParams().set('price', price);
        return this.http.get("http://localhost:8080/api/v2/filter/products", {params:param1});
      }

      // filter price data in acending order
      getFilteredData(){
        return this.http.get("http://localhost:8080/api/v2/sorting/price");
      }

         // get all products reviews by ProductId
        public loadPosts(id: number){
        let x: Observable<Products[]>;
        x = this.http.get<Products[]>("http://localhost:8080/api/v3/reviews/"+id);
        return x;
      }
  }
