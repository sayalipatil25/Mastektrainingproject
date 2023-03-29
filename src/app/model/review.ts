import { Products } from "./product";

export interface Review{
  reviewid : number;
  rating : number;
  reviewtext : string;
  productid: number;
  userid: number;
  product: Products[];
  //user: User[];
}
