package com.grygierczyk.system_repo;

import com.grygierczyk.models.BibsItem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibsItemRepository extends JpaRepository<BibsItem,Integer> {
    List<BibsItem> findAll(Specification<BibsItem> spec);
    List<BibsItem> findByCreatedDate(String createdDate);
    List<BibsItem> findBySubject(String subject);
    List<BibsItem> findByAuthor(String author);
    List<BibsItem> findByTitle(String title);
    List<BibsItem> findByPublisher(String publisher);
    List<BibsItem> findByKind(String kind);
    List<BibsItem> findByFormOfWork(String formOfWork);
    List<BibsItem> findByGenre(String genre);
    List<BibsItem> findByPublicationYear(String publicationYear);


}
