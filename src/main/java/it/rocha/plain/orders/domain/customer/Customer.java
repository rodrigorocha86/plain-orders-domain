package it.rocha.plain.orders.domain.customer;

import java.time.LocalDate;

public final class Customer {

    private final String code;
    private final Cpf cpf;
    private String name;
    private LocalDate birthdate;

    public Customer(
            String code, Cpf cpf,
            String name, LocalDate birthdate) {
        if(code == null) {
            throw new IllegalArgumentException("Code is mandatory.");
        }
        this.code = code;

        if(cpf == null) {
            throw new IllegalArgumentException("CPF is mandatory.");
        }
        this.cpf = cpf;

        changeName(name);
        changeBirthdate(birthdate);
    }

    public void changeName(String name) {
        if(name == null
                || name.length() <= 1
                || name.length() > 50) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        this.name = name;
    }

    public void changeBirthdate(LocalDate birthdate) {
        if(birthdate == null
                || birthdate.isAfter(LocalDate.parse("1990-01-01"))) {
            throw new IllegalArgumentException("Invalid bithdate: " + birthdate);
        }
        this.birthdate = birthdate;
    }

    public String getCode() { return code; }

    public Cpf getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}