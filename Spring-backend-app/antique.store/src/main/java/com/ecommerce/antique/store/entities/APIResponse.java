package com.ecommerce.antique.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<Product> {
	
	// for searching products by fields
	int recordCount;
	Product response;
}
