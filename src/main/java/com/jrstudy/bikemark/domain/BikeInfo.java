package com.jrstudy.bikemark.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column
    private String stationId;

    @Column
    private String stationName;

    @Column
    private String stationImgFileName;

    @Column
    private String userSeq;

    @Column
    private String lang;

    @Column
    private String pageYn;

    @Column
    private Integer rackTotCnt;

    @Column
    private Integer bikeTotCnt;

    @Column
    private String locateNo;

    @Column
    private String rackRate;

    @Column
    private Integer parkingRackTotCnt;

    @Column
    private Integer parkingBikeTotCnt;

    @Column
    private Integer shared;

    @Column
    private BigDecimal stationLatitude;

    @Column
    private BigDecimal stationLongitude;

    @Column
    private String parkingRack;

    @Column
    private String parkingBike;

    @Column
    private String criticalFlg;

    @Column
    private String closeFlg;

    @Column
    private String systemWarning;

    @Column
    private String currentStatus;

    @Column
    private String stationAddr;

    @Column
    private String stationGrpSeq;

    @Column
    private String stationPostNo;

    @Column
    private String stationClsCd;

    @Column
    private String stationClsName;

    @Column
    private String brokenApFlg;

    @Column
    private String brokenBikeFlg;

    @Column
    private String brokenArmFlg;

    @Column
    private String stationUserYn;

    @Column
    private String rackUsableCnt;

    @Column
    private String bkmkSeq;

    @Column
    private String stationUseCnt;

    @Column
    private LocalDateTime createdAt;
}
