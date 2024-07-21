package com.estrella.microservice.client.rest.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estrella.microservice.client.rest.postgres.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
