import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  order:any;
  constructor(private http:HttpClient){ }

  ngOnInit(): void {
      this.getAllOrders();
  }

  getAllOrders()
  {
    this.http.get<any>("http://localhost:8080/api/v1/orderhistory").subscribe(
      response=>{
        console.log(response);
        this.order=response;
      }
    );
  }

}
