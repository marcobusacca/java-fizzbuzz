package org.java.spring.db.repo;

import org.java.spring.db.pojo.Num;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumRepository extends JpaRepository<Num, Integer> {

}
