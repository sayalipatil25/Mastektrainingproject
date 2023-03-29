import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../interface/category';
import { Products } from '../interface/Products';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

http:HttpClient;
products: Products[] = [];
 // baseUrl = "http://localhost:8080/api/v1/";

  constructor(http: HttpClient) {
    this.http=http;
  }

  public getAllProducts(){
    return this.http.get<Products[]>("http://localhost:8080/api/v1/products");
  }

  // public getAllProducts(){

  //   let x: Observable<Products[]>;
  //   x = this.http.get<Products[]>("http://localhost:8080/api/v1/products");
  //   return x;
  //  }

  // get product by ID
  public getProduct(id: number){
    let x: Observable<Products>;
    x = this.http.get<Products>("http://localhost:8080/api/v1/products/" + id);
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
   return this.http.get("http://localhost:8080/api/v1/page/products?pgnum=" + pgnum + '&size=' + size);
  }

      // search products
      getSearchedData(value : string){
        return this.http.get("http://localhost:8080/api/v1/search?key=" + value);
      }

      // filter the data
      getFilterDataByPrice(price: number): Observable<any>{
        let param1 = new HttpParams().set('price', price);
        return this.http.get("http://localhost:8080/api/v1/filter/products", {params:param1});
      }

      // filter price data in acending order
      getFilteredData(){
        return this.http.get("http://localhost:8080/api/v1/sorting/price");
      }

         // get all products reviews by ProductId
        public loadPosts(id: number){
        let x: Observable<Products[]>;
        x = this.http.get<Products[]>("http://localhost:8080/api/v1/reviews/"+id);
        return x;
      }
}
