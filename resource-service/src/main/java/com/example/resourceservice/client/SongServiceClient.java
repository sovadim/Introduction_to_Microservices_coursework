package com.example.resourceservice.client;

import com.example.resourceservice.dto.SongMetadataDto;
import com.example.resourceservice.exception.SongServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class SongServiceClient {

    private final RestTemplate restTemplate;
    private final String songServiceUrl;

    public SongServiceClient(RestTemplate restTemplate,
                             @Value("${song-service.url}") String songServiceUrl) {
        this.restTemplate = restTemplate;
        this.songServiceUrl = songServiceUrl;
    }

    public void createSong(SongMetadataDto dto) {
        try {
            restTemplate.postForObject(songServiceUrl + "/songs", dto, Map.class);
        } catch (RestClientException e) {
            throw new SongServiceException("Failed to save song metadata: " + e.getMessage());
        }
    }
}
