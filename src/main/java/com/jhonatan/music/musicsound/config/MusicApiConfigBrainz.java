package com.jhonatan.music.musicsound.config;

import org.springframework.beans.factory.annotation.Value;

public class MusicApiConfigBrainz {
    @Value("${music.api.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
