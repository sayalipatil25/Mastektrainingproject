import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/interface/Products';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public product: any=[];

  //public cartTotal: number;
  public grandTotal!:number;
  public quantity : number=1;

  constructor(private cartService: CartService) { }

//   increment() {
//     this.quantity += 1;
// }

// decrement() {
//     if(this.quantity >1){
//         this.quantity -= 1;
//     }
// }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.product=res;
      console.log(this.product);
      this.grandTotal=this.cartService.getTotalPrice();

    })
  }

  removeItem(item:any){
    this.cartService.removeCartItem(item);
      }
      emptycart(){
        this.cartService.removeAllCart();

      }

      showMessage(){
        alert("We are going to process your order..Please click on Ok to fill shipping address");
      }

      getTotalPrice(data:any){
        let subTotal=0;
        for(const item of data)
        {
          subTotal+=item.product.price*item.quantity;
        }
        return subTotal;
      }

      inc(item:any){
        if(item.quantity!=5)
        item.quantity+=1;

        this.grandTotal=this.getTotalPrice(this.product);
      }

      dec(item:any){
        if(item.quantity !=1){
          item.quantity-=1;
        }
        this.grandTotal=this.getTotalPrice(this.product);

      }


}

