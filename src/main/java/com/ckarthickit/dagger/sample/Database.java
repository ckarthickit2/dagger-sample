package com.ckarthickit.dagger.sample;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    Database() {
    }

    public Account getAccount(String userName) {
        //computeIfAbsent expects a "Function"
        // that accepts "String" type as param and returns "Account" type as return value
        return accounts.computeIfAbsent(userName, Account::new);
    }

    public static class Account {
        private final String userName;
        private final BigDecimal balance = BigDecimal.ZERO;

        public Account(String userName) {
            this.userName = userName;
        }

        public String userName() {
            return userName;
        }

        public BigDecimal balance() {
            return balance;
        }
    }
}
