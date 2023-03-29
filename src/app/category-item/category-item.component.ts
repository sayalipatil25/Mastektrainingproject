import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { interval } from 'rxjs';
import { Category } from '../model/category';
import { Products } from '../model/product';
import { CategoryService } from '../service/category.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-category-item',
  templateUrl: './category-item.component.html',
  styleUrls: ['./category-item.component.css']
})
export class CategoryItemComponent implements OnInit {

  id:any;
  p: number = 1;
  activeroute: ActivatedRoute;
  service: ProductService;
  products!: Products [];
  category: Category = <Category>{};

  constructor(activeroute: ActivatedRoute,service: ProductService) {
  this.activeroute = activeroute;
  this.service = service;

  }
  ngOnInit(): void {
    const id = parseInt(this.activeroute.snapshot.params['id']);
    this.service.getProductByCategoryId(id).subscribe((data)=>{
      this.category = data;
      this.products = this.category.product;
      console.log(typeof this.products)
      console.log(this.products)},
      (error)=>{console.log(error);},
      ()=>{console.log("no further data");})

    }

    refresh(): void {
      window. location. reload();
      }

}
