package com.simplesdental.product.service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Component
public class ObjectsValidator<T> {
 
 private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
 
 private final Validator validator = factory.getValidator();
 
 public Set<String> validate(T objectToValidate) {
  
  Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
  
  if(!violations.isEmpty()) {
   return violations
     .stream()
     .map(ConstraintViolation::getMessage)
     .collect(Collectors.toSet());
  }
  return Collections.emptySet();
 }

}
