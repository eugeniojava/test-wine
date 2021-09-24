package com.eugeniojava.testwine.repository;

import com.eugeniojava.testwine.model.ServiceArea;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceAreaRepository extends JpaRepository<ServiceArea, Long> {

    @Query(value = "SELECT CASE WHEN COUNT(sa) > 0 THEN true ELSE false END " +
            "FROM ServiceArea sa " +
            "WHERE (?1 BETWEEN sa.startRange AND sa.endRange) " +
            "OR (?2 BETWEEN sa.startRange AND sa.endRange)")
    boolean isRangeInUse(long startRange, long endRange);

    @Query(value = "SELECT sa FROM ServiceArea sa WHERE ?1 BETWEEN sa.startRange AND sa.endRange")
    Optional<ServiceArea> findByArea(long area);
}
