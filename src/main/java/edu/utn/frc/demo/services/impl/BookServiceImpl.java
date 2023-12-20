package edu.utn.frc.demo.services.impl;
import edu.utn.frc.demo.domain.Book;
import edu.utn.frc.demo.services.BookService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//2: IMPLEMENTACIÓN DE INTERFAZ PREVIAMENTE DEFINIDA
@Service
public class BookServiceImpl implements BookService{

    //Declarar mapa de libros con clave Integer y valor Book
    private static final Map<Integer, Book> bookLibrary = new ConcurrentHashMap<>();

    //Método para crear libro
    //Utiliza método put de ConcurrentHashMap
    //En (.put()) ingresa parámetros id y un nuevo libro
    @Override
    public Book createBook(Book book){
        bookLibrary.put(book.getId(), book);
        return book;
    }

    //Método para obtener libro por ID
    //Utiliza método get de ConcurrentHashMap
    @Override
    public Book getBookById(Integer id){
        return bookLibrary.get(id);
    }

    //Método para actualizar datos de libro
    //Recibe un ID y el JSON de un libro a actualizar
    @Override
    public Book updateBook(Integer id, Book book){
        bookLibrary.put(id, book);
        return book;
    }

    //Método para obtener libro por título, recibe una String con el título
    //Recorre el mapa de libros con (.values()) y compara el título de cada libro con el título recibido
    //Si no encuentra ningún libro, devuelve null
    @Override
    public Book getBookByTitle(String title){
        for (Book book : bookLibrary.values()){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    //Método para eliminar libro por ID
    //Utiliza método remove de ConcurrentHashMap
    @Override
    public Book deleteBook(Integer id){
        return bookLibrary.remove(id);
    }
}
