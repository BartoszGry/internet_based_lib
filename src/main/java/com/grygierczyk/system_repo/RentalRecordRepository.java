package com.grygierczyk.system_repo;

import com.grygierczyk.models.RentalRecord;
import com.grygierczyk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRecordRepository extends JpaRepository<RentalRecord,Integer> {
    List<RentalRecord> findByUser(User user);
}
