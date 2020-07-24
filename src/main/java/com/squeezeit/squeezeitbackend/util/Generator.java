package com.squeezeit.squeezeitbackend.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Generator {
    private static final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String generate() {
        long num = ThreadLocalRandom.current().nextLong(0, 56_800_235_584L);
        return makeBase62(num);
    }

    private String makeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        long length = alphabet.length();

        while (num != 0) {
            sb.insert(0, alphabet.charAt((int) (num % length)));
            num /= length;
        }

        return "0".repeat(6 - sb.length()) + sb.toString();
    }
}