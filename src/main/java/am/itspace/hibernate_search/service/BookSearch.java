package am.itspace.hibernate_search.service;

import am.itspace.hibernate_search.model.Book;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookSearch {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> searchBooks(String text) {
        Query query = getQueryBuilder()
                .keyword()
                .onFields("title", "subtitle", "authors.name")
                .matching(text)
                .createQuery();
        return getJpaQuery(query).getResultList();
    }

    private QueryBuilder getQueryBuilder() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Book.class)
                .get();
    }

    private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        return fullTextEntityManager.createFullTextQuery(luceneQuery, Book.class);
    }

}
