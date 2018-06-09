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
public class MediaService {
    private final Environment env;

    public MediaService(Environment env) {
        this.env = env;
    }

    public byte[] getImage(String fileName, String userId, String pwdHash) throws IOException {
        String[] mediaServiceAddresses = env.getProperty("media.services").split(",");
        String authServiceAddress = chooseMediaService(mediaServiceAddresses);
        String url = resolveUrl(authServiceAddress, fileName, userId, pwdHash);
        return getResponse(url);
    }

    private String resolveUrl(String host, String filename, String userId, String pwdHash){
        return "http://" + host + "/image/" + filename +"?userId=" + userId + "&pwdHash=" + pwdHash;
    }

    private byte[] getResponse(String url) throws IOException {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        return response.getEntity(byte[].class);
    }

    private String chooseMediaService(String[] services){
        return services[new Random().nextInt(services.length)];
    }

}
