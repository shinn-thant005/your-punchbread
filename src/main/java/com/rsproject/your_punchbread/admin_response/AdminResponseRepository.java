package com.rsproject.your_punchbread.admin_response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminResponseRepository extends JpaRepository<AdminResponse, Integer> {
}
