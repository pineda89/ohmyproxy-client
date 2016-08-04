package me.ohmyproxy.connector;

import com.google.gson.Gson;
import me.ohmyproxy.domain.Response;


public class JsonParser {
    public static Response parseStringToResponse(String responseString) {
        try {
            return new Gson().fromJson(responseString, Response.class);
        } catch (Exception e) {
            return new Response();
        }

    }
}
