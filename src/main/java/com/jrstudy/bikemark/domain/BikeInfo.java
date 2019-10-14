package com.jrstudy.bikemark.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class BikeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stationId;
    private String stationName;
    private String stationImgFileName;
    private String userSeq;
    private String lang;
    private String pageYn;
    private String rackTotCnt;
    private String bikeTotCnt;
    private String locateNo;
    private String rackRate;
    private String parkingRackTotCnt;
    private String parkingBikeTotCnt;
    private String shared;
    private String stationLatitude;
    private String stationLongitude;
    private String parkingRack;
    private String parkingBike;
    private String criticalFlg;
    private String closeFlg;
    private String systemWarning;
    private String currentStatus;
    private String stationAddr;
    private String stationGrpSeq;
    private String stationPostNo;
    private String stationClsCd;
    private String stationClsName;
    private String brokenApFlg;
    private String brokenBikeFlg;
    private String brokenArmFlg;
    private String stationUserYn;
    private String rackUsableCnt;
    private String bkmkSeq;
    private String stationUseCnt;
}
