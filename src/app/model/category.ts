import { Products } from "./product";
import { Review } from "./review";

export interface Category{
  categoryid: any;
  categoryname: any;
  categorydescription: any;
  categoryimage: any;
  product : Products[];
  review : Review[];
}
