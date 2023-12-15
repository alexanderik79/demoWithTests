package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Document;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE documents SET is_active = false WHERE employee_id = :id", nativeQuery = true)
    void updateAllDocumentsSetIsActiveFalse(@Param("id") Integer id);


}
