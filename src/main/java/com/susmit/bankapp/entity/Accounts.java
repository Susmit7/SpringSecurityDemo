package com.susmit.bankapp.entity;

import com.susmit.bankapp.enums.AccountType;
import java.util.Date;

public record Accounts(String uuid, String profileUUID, double balance, Date createdAt, AccountType accountType) {
}
