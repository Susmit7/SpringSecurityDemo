package com.susmit.bankapp.entity;


public record Profile(String uuid, String userName, String password, String name, ContactDetails contactDetails) {
}
