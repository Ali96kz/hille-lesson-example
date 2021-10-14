package com.hillel.car.shop.encryption;

public class NoEncryptionService implements EncryptionService{

    @Override
    public String encrypt(String value) {
        return "";
    }
}
