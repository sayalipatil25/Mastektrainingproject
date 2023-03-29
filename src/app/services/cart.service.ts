import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { order } from '../interface/order';
import { Products } from '../interface/Products';


@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList: any=[]
  public productLList= new BehaviorSubject<any>([]);



  constructor() { }

  getProducts(){
   return this.productLList.asObservable();

  }
  setProduct(product: any){
    this.cartItemList.push(...product);
    this.productLList.next(product);
  }

  addtoCart(product:any){

    let orderItem={
      "quantity":1,
      "product":product

    }
    this.cartItemList.push(orderItem);
    this.productLList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList);

  }




  getTotalPrice(): number{
    let grandTotal=0;
    this.cartItemList.map((a:any)=>{
      // grandTotal+=a.total;
      grandTotal=grandTotal+(a.product.price*a.quantity)
    })
    return grandTotal;


    // let grandTotal=0;
    // grandTotal=this.cartItemList.quantity* this.cartItemList.price;



  }



  removeCartItem(product:any){
    this.cartItemList.map((a:any, index:any)=>{
if(product.id===a.id){
this.cartItemList.splice(index,1);
}
    })
    this.productLList.next(this.cartItemList);
  }
  removeAllCart(){
    this.cartItemList=[]
    this.productLList.next(this.cartItemList);
  }

}



