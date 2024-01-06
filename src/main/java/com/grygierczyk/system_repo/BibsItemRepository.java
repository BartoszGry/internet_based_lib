package com.grygierczyk.system_repo;

import com.grygierczyk.system_bibioteki.BibsItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibsItemRepository extends JpaRepository<BibsItem,Integer> {

}
