package org.java.spring.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<org.java.spring.db.pojo.Number, Integer> {

}
