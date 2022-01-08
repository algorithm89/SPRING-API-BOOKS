package com.example.books;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import com.example.books.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
