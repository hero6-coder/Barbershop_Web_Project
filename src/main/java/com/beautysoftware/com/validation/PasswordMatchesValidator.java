package com.beautysoftware.com.validation;

import com.beautysoftware.com.modelDto.RegisterClientDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{
    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final RegisterClientDto user = (RegisterClientDto) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
