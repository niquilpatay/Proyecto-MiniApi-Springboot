package edu.utn.frc.demo.domain;
import lombok.*;

//0a: CLASE BOOK CON IDENTIFICADORES DE LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private Author author;
    private Genre genre;
}
