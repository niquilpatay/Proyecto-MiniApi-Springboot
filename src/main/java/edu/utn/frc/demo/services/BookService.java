package edu.utn.frc.demo.services;
import edu.utn.frc.demo.domain.Book;

//1: INTERFAZ CON MÉTODOS A REDEFINIR
public interface BookService {
    Book createBook(Book book);
    Book getBookById(Integer id);
    Book updateBook(Integer id, Book book);
    Book getBookByTitle(String title);
    Book deleteBook(Integer id);
}
