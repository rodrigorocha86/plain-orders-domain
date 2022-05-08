package it.rocha.plain.orders.domain.entity;

import java.time.LocalDate;

public final class Customer {

    private final Cpf cpf;
    private String name;
    private LocalDate birthdate;

    public Customer(
            Cpf cpf, String name,
            LocalDate birthdate) {
        validate(cpf);
        this.cpf = cpf;

        changeName(name);
        changeBirthdate(birthdate);
    }

    private void validate(Cpf cpf) {
        if(cpf == null) {
            throw new IllegalArgumentException("CPF is mandatory.");
        }
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