package com.twu.biblioteca.model.status;

import com.twu.biblioteca.model.BookStatus;

public class BookBeenLentedStaus extends BookStatus {
    @Override
    public String toString() {
        return "That book is not available.\r\n";
    }
}
