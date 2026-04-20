package com.rsproject.your_punchbread.app_status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppStatusRepository extends JpaRepository<AppStatus, Integer> {
}
