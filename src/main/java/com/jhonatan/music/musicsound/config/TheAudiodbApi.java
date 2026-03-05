package com.jhonatan.music.musicsound.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TheAudiodbApi {
    @Value("${music.api.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
