package com.xavo.finance.wallet.entities;

public enum AccountType {
    DEBIT("D"), CREDIT_CARD("C"), INVESTMENT("I");

    private String code;

    private AccountType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
