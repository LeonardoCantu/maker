package com.teste.maker.pattern.consumer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class APIConsumer {

    public JSONObject execute(String url) {
        try {
            HttpResponse<JsonNode> response = Unirest.post(url).asJson();
            return response.getBody().getObject();
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possivel baixar os dados da url informada");
        }
    }
}
