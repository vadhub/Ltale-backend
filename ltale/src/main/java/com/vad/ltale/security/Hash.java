package com.vad.ltale.security;

import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String digest(String msg) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(msg.getBytes());
        return new String(Hex.encode(messageDigest.digest()));
    }
}
