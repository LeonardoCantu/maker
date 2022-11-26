package com.teste.maker.pattern.validator;

public interface IValidator<E> {

    void validateRequiredFields(E entidade);

}
