package com.xavo.finance.wallet.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {
 
    @Override
    public String convertToDatabaseColumn(AccountType type) {
        if (type == null) {
            return null;
        }
        return type.getCode();
    }

    @Override
    public AccountType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return java.util.stream.Stream.of(AccountType.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}