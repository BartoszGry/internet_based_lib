package com.grygierczyk.system_repo;

import com.grygierczyk.system_bibioteki.MARC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MARCRepository extends JpaRepository<MARC,Integer> {
}
