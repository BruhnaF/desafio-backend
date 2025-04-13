package com.simplesdental.product.service.users;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

import com.simplesdental.product.model.RoleType;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { RolesAllowed.Validator.class })
public @interface RolesAllowed {

    String message() default "Field value should be from list of ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    RoleType[] values();

    class Validator implements ConstraintValidator<RolesAllowed, RoleType> {
        private String propName;
        private String message;
        private List<RoleType> allowable;

        @Override
        public void initialize(RolesAllowed requiredIfChecked) {
            this.propName = requiredIfChecked.propName();
            this.message = requiredIfChecked.message();
            this.allowable = Arrays.asList(requiredIfChecked.values());
        }

        public boolean isValid(RoleType value, ConstraintValidatorContext context) {
            Boolean valid = this.allowable.contains(value);

            if (!Boolean.TRUE.equals(valid)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message.concat(this.allowable.toString()))
                        .addPropertyNode(this.propName).addConstraintViolation();
            }
            return valid;
        }
    }
}
