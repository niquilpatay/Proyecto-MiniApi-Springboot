package edu.utn.frc.demo.controllers;
import edu.utn.frc.demo.domain.Book;
import edu.utn.frc.demo.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//3: CONTROLADOR REST PARA LA ENTIDAD LIBRO
//Slf4j: Simple Logging Facade for Java
@Slf4j
@RestController
public class BookController {

    //Crear nueva interfaz para utilización de métodos
    private final BookService bookService;

    //Autowired: Inyección de dependencias
    //Inyecta la interfaz BookService
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Método GET para probar conexión
    @GetMapping("/ping")
    String pingPong(){
        //En la ruta /ping, se devuelve un valor "pong"
        return "pong";
    }

    //Método POST para crear libro
    //En la ruta /book ingresar libro a través del JSON
    //RequestBody: el método requiere un objeto en el cuerpo de la petición
    @PostMapping("/book")
    Book createBook(@RequestBody Book book){
        //Llamar método para crear libro a través de la interfaz
        return bookService.createBook(book);
    }
    /* JSON DE CREACIÓN DE LIBRO
    {
        "id" : 1,
        "title" : "Libro1",
        "author":{
            "name" : "Autor1"
        } ,
        "genre":{
            "name" : "Novela"
    }*/


    //Método GET para obtener libro por ID
    //PathVariable: el método requiere un parámetro en la URL ({id})
    @GetMapping("/book/{id}")
    Book getBook(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    /*Sobreescribir método getBook por id (prueba)
    @GetMapping("/book/{id}")
    Book getBook(@PathVariable Integer id, @RequestHeader(required = false) String username){
        log.info("request from user: {}", username);
        return bookService.getBookById(id);
    }*/

    //Método GET para obtener libro por título
    //RequestParam: espera un parámetro title desde la solicitud HTTP
    @GetMapping("/book")
    Book getBookByName(@RequestParam String title){
        return bookService.getBookByTitle(title);
    }

    //Método PUT para actualizar libro
    @PutMapping("/book/{id}")
    Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    //Método DELETE para eliminar libro
    @DeleteMapping("/book/{id}")
    Book deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}

