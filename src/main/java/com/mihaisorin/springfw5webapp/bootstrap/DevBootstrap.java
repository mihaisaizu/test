package com.mihaisorin.springfw5webapp.bootstrap;

import com.mihaisorin.springfw5webapp.model.Author;
import com.mihaisorin.springfw5webapp.model.Book;
import com.mihaisorin.springfw5webapp.model.Publisher;
import com.mihaisorin.springfw5webapp.repositories.AuthorRepository;
import com.mihaisorin.springfw5webapp.repositories.BookRepository;
import com.mihaisorin.springfw5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("Corint");
        publisher1.setAddress("Romania, Craiova");

        Publisher publisher2 = new Publisher();
        publisher2.setName("carturesti");
        publisher2.setAddress("Romania, Bucuresti");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Author matei = new Author("Matei", "Saizu");
        Book aie = new Book("Artificial Inteligence Explained", "12340", publisher1);
        matei.getBooks().add(aie);
        aie.getAuthors().add(matei);

        authorRepository.save(matei);
        bookRepository.save(aie);

        Author sofia = new Author("Sofia", "Saizu");
        Book bwl = new Book("Boring. White Love", "5554544", publisher2);
        sofia.getBooks().add(bwl);
        bwl.getAuthors().add(sofia);

        authorRepository.save(sofia);
        bookRepository.save(bwl);
    }
}
