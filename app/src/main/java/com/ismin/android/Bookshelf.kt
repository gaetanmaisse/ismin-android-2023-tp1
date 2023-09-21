package com.ismin.android

import java.lang.IllegalArgumentException

class Bookshelf {

    private val storage = HashMap<String, Book>()

    fun addBook(book: Book) {
        storage[book.isbn] = book
    }

    fun getBook(isbn: String): Book {
        val book = storage[isbn]
        if (book == null) {
            throw IllegalArgumentException("Unknown isbn")
        }
        return book
    }

    fun getAllBooks(): List<Book> {
        return storage.values
            .sortedBy { book -> book.title }
    }

    fun getBooksOf(author: String): List<Book> {
        return storage.filterValues { book -> book.author.equals(author) }
            .values
            .sortedBy { book -> book.title }
    }

    fun getTotalNumberOfBooks(): Int {
        return storage.size
    }

}
