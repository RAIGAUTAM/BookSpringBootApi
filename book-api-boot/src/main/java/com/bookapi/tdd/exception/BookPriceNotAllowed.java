package com.bookapi.tdd.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class BookPriceNotAllowed extends RuntimeException{
	private String resourceName;
    private String fieldName;
    private Object fieldValue;
    
    public BookPriceNotAllowed( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s price not allowed greator than 2000. And you have entered %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
    
    
}
