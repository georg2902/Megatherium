package org.rolofge.application.backend.repository;

import org.rolofge.application.backend.entity.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingRepository extends JpaRepository<Outgoing, String> {

}
