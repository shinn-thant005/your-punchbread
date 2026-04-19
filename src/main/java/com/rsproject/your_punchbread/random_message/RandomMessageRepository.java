package com.rsproject.your_punchbread.random_message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomMessageRepository extends JpaRepository<RandomMessages, Integer>{
}
