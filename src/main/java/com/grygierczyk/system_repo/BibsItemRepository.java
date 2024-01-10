package com.grygierczyk.system_repo;

import com.grygierczyk.entity.BibsItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibsItemRepository extends JpaRepository<BibsItem,Integer> {

}
