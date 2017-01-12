package com.twu.biblioteca;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Getter @Setter
    private String title;
    @Getter
    private String author;
    @Getter
    private int year;

}
