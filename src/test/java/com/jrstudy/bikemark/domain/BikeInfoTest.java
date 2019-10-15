package com.jrstudy.bikemark.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.doesNotHave;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BikeInfoTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getRealtimeBikeInfo() throws Exception {
        String url = "https://www.bikeseoul.com/app/station/getStationRealtimeStatus.do?stationGrpSeq=ALL";
        RestTemplate restTemplate = new RestTemplate();
        String resultString = restTemplate.postForObject(URI.create(url), null, String.class);

        Map<String, List> map = objectMapper.readValue(resultString, new TypeReference<Map>() {});
        List<Map> list = (List<Map>) map.get("realtimeList");

        BikeInfo bikeInfo = objectMapper.convertValue(list.get(0), BikeInfo.class);
        assertThat(bikeInfo.getStationName().equals("300. 정동사거리"));
    }

}
