package com.jrstudy.bikemark.schedul;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrstudy.bikemark.domain.BikeInfo;
import com.jrstudy.bikemark.domain.BikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class BikeInfoScheduler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    BikeInfoService bikeInfoService;

    @Scheduled(cron = "* 0/30 * * * *")
    public void saveBikeInfo() throws IOException {
        String url = "https://www.bikeseoul.com/app/station/getStationRealtimeStatus.do?stationGrpSeq=ALL";
        RestTemplate restTemplate = new RestTemplate();
        String resultString = restTemplate.postForObject(URI.create(url), null, String.class);

        Map<String, List> map = objectMapper.readValue(resultString, new TypeReference<Map>() {});
        List<Map> list = (List<Map>) map.get("realtimeList");

        LocalDateTime createdAt = LocalDateTime.now();

        for (Map data : list) {
            BikeInfo bikeInfo = objectMapper.convertValue(data, BikeInfo.class);
            bikeInfo.setCreatedAt(createdAt);
            bikeInfoService.save(bikeInfo);
        }
    }
}
