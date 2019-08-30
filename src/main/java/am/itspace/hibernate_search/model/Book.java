package am.itspace.hibernate_search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Indexed
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    @Field
    private String title;
    @Field
    private String subtitle;
    @ManyToMany
    @IndexedEmbedded
    @ContainedIn
    private Set<Author> authors = new HashSet<>();
    private Date publicationDate;

}