package com.sorting.sortingpayload.validator;

import com.sorting.sortingpayload.model.SortRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KeysValueMatchValidator implements ConstraintValidator<KeysValueMatch, SortRequest> {
    @Override
    public boolean isValid(SortRequest request,
                           ConstraintValidatorContext constraintValidatorContext) {
        return request.getSortKeys()
                .stream()
                .allMatch(key -> request.getPayload().containsKey(key));
    }
}
