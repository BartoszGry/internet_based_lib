//package com.grygierczyk.system_repo;
//
//import com.grygierczyk.entity.BibsItem;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface BibsItemRepository extends JpaRepository<BibsItem,Integer> {
//    List<BibsItem> findByZone(String zone);
//    List<BibsItem> findByCreatedDate(String createdDate);
//    List<BibsItem> findByUpdatedDate(String updatedDate);
//    List<BibsItem> findByDeleted(boolean deleted);
//    List<BibsItem> findByDeletedDate(String deletedDate);
//    List<BibsItem> findByLanguage(String language);
//    List<BibsItem> findBySubject(String subject);
//    List<BibsItem> findBySubjectPlace(String subjectPlace);
//    List<BibsItem> findBySubjectTime(String subjectTime);
//    List<BibsItem> findBySubjectWork(String subjectWork);
//    List<BibsItem> findByIsbnIssn(String isbnIssn);
//    List<BibsItem> findByAuthor(String author);
//    List<BibsItem> findByPlaceOfPublication(String placeOfPublication);
//    List<BibsItem> findByLocation(String location);
//    List<BibsItem> findByTitle(String title);
//    List<BibsItem> findByUdc(String udc);
//    List<BibsItem> findByPublisher(String publisher);
//    List<BibsItem> findByKind(String kind);
//    List<BibsItem> findByDomain(String domain);
//    List<BibsItem> findByFormOfWork(String formOfWork);
//    List<BibsItem> findByGenre(String genre);
//    List<BibsItem> findByTimePeriodOfCreation(String timePeriodOfCreation);
//    List<BibsItem> findByAudienceGroup(String audienceGroup);
//    List<BibsItem> findByDemographicGroup(String demographicGroup);
//    List<BibsItem> findByNationalBibliographyNumber(String nationalBibliographyNumber);
//    List<BibsItem> findByPublicationYear(String publicationYear);
//    List<BibsItem> findByLanguageOfOriginal(String languageOfOriginal);
//
//}
