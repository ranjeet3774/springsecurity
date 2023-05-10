package com.ranjeecode.spring.security.enity;

import java.io.Serializable;

public class JwtResponse  implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    private String token;
}
