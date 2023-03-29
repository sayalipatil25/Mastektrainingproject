package com.ecommerce.antique.store.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdReq {
	
	   @JsonProperty("id")
		   private long id;

		   public Long getId() {
		      return this.id;
		   }

		   public void setId(long id) {
		      this.id = id;
		   }
		}

