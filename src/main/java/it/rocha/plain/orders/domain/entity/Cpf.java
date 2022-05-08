package it.rocha.plain.orders.domain.entity;

public final class Cpf {
    private final String value;

    public Cpf(String cpf) {
        validate(cpf);
        this.value = cpf;
    }

    public String getValue() {
        return value;
    }

    private void validate(String cpf) {
        //TODO validate CPF
    }
}
