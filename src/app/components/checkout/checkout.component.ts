import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Address } from 'src/app/interface/address';

import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
public productList: any=[];
  //public orderproduct: any=[];
  //order:order=new order();
  //orderitem:orderitem=new orderitem();

  public products:any=[];
  public grandTotal !:number;
  address: Address=new Address();





//@Input() orders = {productid:'', productname: '', productdescription: '', price:'', quantity : '', total: ''};


  constructor(private cartService: CartService, private checkoutService : CheckoutService, public route: Router) {

   }

  ngOnInit(): void {

    // this.cartService.getProducts()
    // .subscribe((res)=>{
    //   this.order=res;
    //   this.grandTotal=this.cartService.getTotalPrice();

    // })


  }

  saveOrder(){
    console.log(this.address);
    let totalQuantity=0;
    let totalPrice=0;
    let productItems:any=[];

    this.cartService.getProducts().subscribe(products=>{
      products.forEach((product:any)=>{
        totalQuantity+=product.quantity;
      });
      totalPrice=this.cartService.getTotalPrice();
      productItems=products;
    });

    let newOrder={

      "orderitemquantity": totalQuantity,
      "totalprice":totalPrice,
        "user": {
            "userid": 6,
            "username": "sayali",
            "passwd": "sayali76",
            "firstname": "Sayali",
            "lastname": "Patil",
            "contactno": "9832458736",
            "administrator": false
        },
        "address": {
            "addressline1": this.address.addressline1,
            "addressline2": this.address.addressline2,
            "city": this.address.city,
            "country": this.address.country,
            "postcode": this.address.postcode
        },
        "items": productItems
    }

    console.log(newOrder);
    this.checkoutService.saveOrderDetails(newOrder).subscribe((result)=>{
      console.log(result);
      this.route.navigate(['orders']);

    });

  }

  // addOrderItem(){
  //   console.log(this.orderitem);
  //   this.checkoutService.saveOrderItemDetails(this.orderitem).subscribe((response:any)=>{
  //     console.log(response);
  //   });
  //   this.route.navigate(['/placeOrder']);
  // }


  addAddressDetails(){
    console.log(this.address)
    this.checkoutService.addNewAddress(this.address).subscribe();
    this.route.navigate(['address']);
  }
  async emptycart(){
    this.cartService.removeAllCart();
  }

// placeOrder(){

// this.checkoutService.addNewOrder(this.order).subscribe();
// console.log(this.order);
// }


showMessage(){
  //console.log(this.order)
  alert("order is placed successfully");
}
}
