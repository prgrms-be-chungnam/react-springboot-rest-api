package com.null0xff.project.library.converter;

import com.null0xff.project.library.dto.BookForm;
import com.null0xff.project.library.model.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * {@code BookForm} DTO를 {@code Book} 엔터티 객체로 변환하는 컨버터.
 * <p>
 * 이 클래스는 {@code BookForm} DTO 객체의 데이터를 {@code Book} 엔터티 객체로 변환하는데 사용됩니다. Spring의 {@code Converter}
 * 인터페이스를 구현하여 변환 로직을 제공합니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @see com.null0xff.project.library.dto.BookForm
 * @see com.null0xff.project.library.model.Book
 * @since 2023-10-25
 */
@Component
public class BookFormToBook implements Converter<BookForm, Book> {

  /**
   * 주어진 {@code BookForm} 객체를 {@code Book} 엔터티로 변환합니다.
   *
   * @param sourceBook 변환될 {@code BookForm} 객체.
   * @return 변환된 {@code Book} 엔터티.
   */
  @Override
  public Book convert(BookForm sourceBook) {
    Book book = new Book();
    if (sourceBook.id() != null) {
      book.setId(sourceBook.id());
    }
    book.setTitle(sourceBook.title());
    return book;
  }

}
