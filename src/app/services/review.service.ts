import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Products } from '../interface/Products';
import { Review } from '../interface/review';


@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  posts: any;
  http: HttpClient;
  reviews: Review[] = [];
  products: Products[] = [];

  constructor(http: HttpClient) {
    this.http = http;
   }

  // get all products reviews by ProductId
  // public loadPosts(id: number){
  //   let x: Observable<Products[]>;
  //   x = this.http.get<Products[]>("http://localhost:8080/api/v3/reviews/id=" +id)
  //   return x;
  // }

  saveProductReview(add:any):Observable<Review>{
    return this.http.post<Review>("http://localhost:8080/api/v1/reviews/add",add);
  }

}
