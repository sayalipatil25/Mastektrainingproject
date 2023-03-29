import { Products } from "./Products";


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
