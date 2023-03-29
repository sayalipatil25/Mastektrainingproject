import { Address } from "./address";
import { orderitem } from "./orderitem";
import { user } from "./user";

export class order {
  orderid?: string;
	orderitemquantity?: number;
	totalprice?: string;
	userid?: user;
  addressid?: Address;
  orderitems?:orderitem[];

 }
