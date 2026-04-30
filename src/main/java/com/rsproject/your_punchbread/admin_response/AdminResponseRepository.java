package com.rsproject.your_punchbread.admin_response;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminResponseRepository extends JpaRepository<AdminResponse, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM kiss;", nativeQuery = true)
    void resetKiss();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM punch", nativeQuery = true)
    void resetPunch();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM mood", nativeQuery = true)
    void resetMood();
}
