package com.teste.maker.pattern.validator;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class ValidateFields {
    private final List<String> nullFields = new ArrayList<>();

    public void add(Object valor, String nome) {
        boolean isNullOrEmpty;
        if (valor instanceof Collection<?>) {
            isNullOrEmpty = valor == null || ((Collection<?>) valor).isEmpty();
        } else if (valor instanceof CharSequence) {
            isNullOrEmpty = valor == null || valor.toString().trim().isEmpty();
        } else if (valor != null && valor.getClass().isArray()) {
            isNullOrEmpty = valor == null || ((Object[]) valor).length == 0;
        } else {
            isNullOrEmpty = valor == null;
        }

        if (isNullOrEmpty) {
            nullFields.add(nome);
        }
    }

    public <T> void add(String nome, T valor, Predicate<? super T> predicateAdd) {
        if (predicateAdd.test(valor)) {
            nullFields.add(nome);
        }
    }

    public void addValor(Number valor, String nome) {
        if (valor == null || valor.doubleValue() <= BigDecimal.ZERO.doubleValue()) {
            nullFields.add(nome);
        }
    }

    public void validate() {
        validate("Os seguites campos devem ser preenchidos: ");
    }

    public void validate(String messageTemplate) {
        if (this.nullFields != null && !this.nullFields.isEmpty()) {

            for (int i = 0; i < nullFields.size(); i++) {
                messageTemplate = concatMessage(messageTemplate, nullFields, i);
            }
            throw new RuntimeException(messageTemplate);
        }
    }

    private String concatMessage(String messageTemplate, List<String> fields, Integer i) {
        return messageTemplate.concat(" ")
                .concat(fields.get(i))
                .concat(i.equals(fields.size() - 1) ? "." : ",");
    }

}
