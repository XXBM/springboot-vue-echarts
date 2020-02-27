package org.sang.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/map")
public class MapController {

    @GetMapping("/travel")
    public String run(@RequestParam(value = "place") String place) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=fHrNQj6DHTjZtfTvfqbsuvTzKc5V9SBl&address="+place;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
