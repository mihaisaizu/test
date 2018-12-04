package com.mihaisorin.springfw5webapp.repositories;

import com.mihaisorin.springfw5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
