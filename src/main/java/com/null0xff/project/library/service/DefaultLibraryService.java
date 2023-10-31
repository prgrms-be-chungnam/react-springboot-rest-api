package com.null0xff.project.library.service;

import com.null0xff.project.library.converter.BookFormToBook;
import com.null0xff.project.library.dto.BookForm;
import com.null0xff.project.library.model.Book;
import com.null0xff.project.library.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * {@code LibraryService} 인터페이스의 기본 구현.
 * <p>
 * 이 서비스는 {@code Book} 엔터티에 대한 CRUD 작업의 핵심 비즈니스 로직을 제공하며, 데이터 액세스를 위해 {@code BookRepository}를 활용합니다.
 * 또한, {@code BookForm}을 {@code Book} 객체로 변환하기 위해 {@code BookFormToBook} 변환기를 사용합니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @see com.null0xff.project.library.model.Book
 * @see com.null0xff.project.library.repository.BookRepository
 * @see com.null0xff.project.library.service.LibraryService
 * @see com.null0xff.project.library.converter.BookFormToBook
 * @since 2023-10-25
 */
@Service
public class DefaultLibraryService implements LibraryService {

  private final BookRepository bookRepository;
  private final BookFormToBook bookFormToBook;

  /**
   * 지정된 도서 리포지토리와 도서 폼 변환기로 새로운 {@code DefaultLibraryService}를 구성합니다.
   *
   * @param bookRepository {@code Book} 데이터 액세스를 관리하는 리포지토리.
   * @param bookFormToBook {@code BookForm}을 {@code Book} 엔터티로 변환하는데 사용하는 변환기.
   */
  public DefaultLibraryService(BookRepository bookRepository, BookFormToBook bookFormToBook) {
    this.bookRepository = bookRepository;
    this.bookFormToBook = bookFormToBook;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Book> listAll() {
    return new ArrayList<>(bookRepository.findAll());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book getById(UUID id) {
    return bookRepository.findById(id).orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book saveOrUpdate(Book book) {
    return bookRepository.save(book);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(UUID id) {
    bookRepository.deleteById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book saveOrUpdateBookForm(BookForm bookForm) {
    return saveOrUpdate(bookFormToBook.convert(bookForm));
  }

}
