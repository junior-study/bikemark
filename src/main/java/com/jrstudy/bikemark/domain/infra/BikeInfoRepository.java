package com.jrstudy.bikemark.domain.infra;

import com.jrstudy.bikemark.domain.BikeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeInfoRepository extends JpaRepository<BikeInfo, Long> {
}
