import { Injectable } from '@angular/core';

import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';

import { GenericPOST } from '../interface/generic-post';

import { order } from '../interface/order';
import { Address } from '../interface/address';
import { BehaviorSubject, Observable } from 'rxjs';
import { orderitem } from '../interface/orderitem';



@Injectable({

  providedIn: 'root'

})

export class CheckoutService  {

  //baseURL="http://localhost:8080/api/v1/orderhistory";
http:HttpClient;
  public cartItemList:any=[]
  public productList=new BehaviorSubject<any>([]);

  constructor(http:HttpClient){
    this.http=http;
  }

  // getOrderDetails():Observable<order[]>{
  //   return this.http.get<order[]>("http://localhost:8080/api/v1/orderhistory");
  // }

  saveOrderDetails(order?:any):Observable<Object>{
    return this.http.post<Object>("http://localhost:8080/api/v1/orders",order);

  }


  // saveOrderItemDetails(orderitem?:orderitem):Observable<Object>{
  //   return this.http.post<Object>(`${this.baseURL}`,orderitem);
  // }

  addNewAddress(address?:Address):Observable<Object>
  {
    return this.http.post<Object>("http://localhost:8080/api/v1/address", address);
  }

  removeAllCartItem(){
    this.cartItemList=[]
    this.productList.next(this.cartItemList);
  }

}







































































  // // Define API

  // apiURL='http://localhost:8080/api/v1/address';

  // constructor(private http: HttpClient) {}

  // // Http Options

  // httpOptions = {

  //   headers: new HttpHeaders({

  //     'Content-Type': 'application/json',

  //   }),

  // };

  // addNewAddress(address: Address):Observable<Object>{


  //   return this.http.post<Object>("http://localhost:8080/api/v1/address",address);

  // }



  // // addNewOrder(order: order){
  // //   return this.http
  // //     .post<GenericPOST>(
  // //       this.apiURL + '/orders/orders',
  // //       JSON.stringify(order),
  // //       this.httpOptions
  // //     ).pipe(map((data,error) => {
  // //       if(data){
  // //         console.log(data)
  // //         window.alert(data.status);
  // //       }
  // //       else{
  // //         window.alert(error);
  // //       }
  // //     })
  // //   );
  // // }

  //  }

