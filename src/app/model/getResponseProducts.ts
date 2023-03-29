import { Products } from "./product";

export interface GetResponseProducts {
  _embedded: {
    products: Products[];
  },
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  }
}
