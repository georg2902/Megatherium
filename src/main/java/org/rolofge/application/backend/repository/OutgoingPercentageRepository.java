package org.rolofge.application.backend.repository;

import org.rolofge.application.backend.entity.OutgoingPercentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingPercentageRepository extends JpaRepository<OutgoingPercentage, String> {

}
