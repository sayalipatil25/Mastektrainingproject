import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from 'src/app/model/product';
import { Review } from 'src/app/model/review';
import { ProductService } from 'src/app/service/product.service';
import { ReviewService } from 'src/app/service/review.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  productService: ProductService;
  product!: Products;
  activateroute: ActivatedRoute;
  router: Router;
  reviewService!: ReviewService;
  public productList : any;
  //review!: Review;
  reviewDetails: any;

  constructor(productservice: ProductService, reviewService: ReviewService, activateroute: ActivatedRoute, router: Router) {
    this.activateroute = activateroute;
    this.router = router;
    this.productService = productservice;
  }

  ngOnInit(): void {
    const id = parseInt(this.activateroute.snapshot.params['id']);
    this.productService.getProduct(id).subscribe((data)=>{
      this.product = data;
      console.log(this.product)},
      (error)=>{console.log(error);},
      ()=>{console.log("no further data");})

      this.productService.loadPosts(id)
      .subscribe((response:any)=>{
          this.reviewDetails=response;
          console.log(this.reviewDetails);
      },(error)=>{
        console.log(error)
      })

  }

}
