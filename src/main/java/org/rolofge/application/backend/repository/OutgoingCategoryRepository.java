package org.rolofge.application.backend.repository;

import org.rolofge.application.backend.entity.OutgoingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingCategoryRepository extends JpaRepository<OutgoingCategory, String> {

}
