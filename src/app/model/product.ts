
import { Review } from "./review";

export interface Products{
  productid: number;
  productname: String;
  productdescription: String;
  productimage: String;
  subcatagoryid: number;
  price: number;
  discountpercent: number;
  discountprice: number;
  quantity: number;
  review : Review[];
}
