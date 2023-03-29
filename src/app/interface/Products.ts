import { Review } from "./review"

export interface Products {
  productid: string;
	productname: string;
	productdescription: string;
	productimage:string;
  categoryid:string;
  price:number;
  discountpercent:number;
  discountprice:number;
  quantity:number;
  // review:Review[];

 }
