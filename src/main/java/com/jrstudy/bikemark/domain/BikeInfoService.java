package com.jrstudy.bikemark.domain;

import com.jrstudy.bikemark.domain.infra.BikeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BikeInfoService {

    @Autowired
    private BikeInfoRepository bikeInfoRepository;

    @Transactional
    public void save(BikeInfo bikeInfo) {
        bikeInfoRepository.save(bikeInfo);
    }
}
