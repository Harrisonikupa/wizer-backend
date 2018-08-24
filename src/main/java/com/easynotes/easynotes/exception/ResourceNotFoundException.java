package com.easynotes.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private String fieldValue;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
    this.resourceName = resourceName;
    this.fieldValue = fieldValue;
    this.fieldName = fieldName;
  }

  public String getResourceName() {
    return resourceName;
  }

  public  String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }
}
