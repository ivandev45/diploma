package com.example.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.Random;

/**
 * Created by ivan on 09.06.18.
 */
public class AuthService {

    private final Environment env;

    public AuthService(Environment env) {
        this.env = env;
    }

    public boolean isCorrectPassword(String userId, String pwdHash) throws IOException {
        String[] authServiceAddresses = env.getProperty("auth.services").split(",");
        String authServiceAddress = chooseAuthService(authServiceAddresses);
        String url = resolveUrl(authServiceAddress, userId, pwdHash);
        String response = getResponse(url);
        return response.equals("true");
    }

    private String resolveUrl(String host, String userId, String pwdHash){
        return "http://" + host + "/auth?userId=" + userId + "&pwdHash=" + pwdHash;
    }

    private String getResponse(String url) throws IOException {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        return response.getEntity(String.class);
    }

    private String chooseAuthService(String[] services){
        return services[new Random().nextInt(services.length)];
    }
}
