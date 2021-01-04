package com.test.payment.account.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum AccountStatus {

    CREATE,
    ERROR,
    SUCCESS;

    @Converter
    public static class Mapper implements AttributeConverter<AccountStatus, String> {

        @Override
        public String convertToDatabaseColumn(AccountStatus accountStatus) {
            return accountStatus.name();
        }

        @Override
        public AccountStatus convertToEntityAttribute(String s) {
            return AccountStatus.valueOf(s);
        }
    }
}
