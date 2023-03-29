import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Router } from '@angular/router';
import { Review } from 'src/app/interface/review';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  posts! : Review;
  id : any;
  reviewService!: ReviewService;

  constructor(private http: HttpClient, private reviewApi: ReviewService, public route: Router) {
  }

  ngOnInit(): void {
     this.onSubmit(this.posts);

  }

  // post review
  onSubmit(data: any){
    this.http.post('http://localhost:8080/api/v1/reviews/add', data)
    .subscribe((result) =>{
      console.warn("result", result)

      if (!data['results']['value'])
      return data;
    })
    console.warn(data);
  }

  // addReview(){
  //   console.log(this.posts);
  //   this.reviewService.saveProductReview(this.posts).subscribe();
  //   this.route.navigate(['posts']);
  // }

}
