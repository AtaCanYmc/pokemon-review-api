package com.atacanymc.pokemonreviewapi.Service.Implementation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService extends BCryptPasswordEncoder {

    @Value("${encryption.salt.rounds}")
    private int saltRounds;
    private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRounds);
    }

    public String encode(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public boolean matches(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
