package com.twu.biblioteca;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Getter @Setter
    private String title;
    @Getter
    private String author;
    @Getter
    private int year;
    @Getter
    private int id;
    @Getter @Setter
    private boolean checkedOut;
}
