package com.null0xff.project.library.service;

import com.null0xff.project.library.dto.BookForm;
import com.null0xff.project.library.model.Book;
import java.util.List;
import java.util.UUID;

/**
 * 도서관의 도서를 관리하기 위한 작업을 정의하는 서비스 인터페이스.
 * <p>
 * 이 서비스는 {@code Book} 엔터티에 대한 CRUD (생성, 읽기, 업데이트, 삭제) 작업을 제공합니다. 컨트롤러와 데이터 액세스 계층 사이의 추상화 계층으로 작동하여
 * 비즈니스 로직이 데이터 처리로부터 분리되도록 합니다.
 * </p>
 * <p>
 * 제공된 작업 중에는 다음과 같은 것들이 있습니다:
 * <ul>
 *   <li>모든 도서 목록화</li>
 *   <li>고유 식별자로 도서 가져오기</li>
 *   <li>도서 저장 또는 업데이트</li>
 *   <li>고유 식별자로 도서 삭제</li>
 * </ul>
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @see com.null0xff.project.library.model.Book
 * @since 2023-10-25
 */
public interface LibraryService {

  /**
   * 도서관의 모든 도서 목록을 검색합니다.
   *
   * @return 모든 {@code Book} 엔터티의 목록.
   */
  List<Book> listAll();

  /**
   * 고유 식별자로 도서를 검색합니다.
   *
   * @param id 검색할 도서의 UUID.
   * @return 지정된 UUID를 가진 {@code Book} 엔터티.
   */
  Book getById(UUID id);

  /**
   * 새 도서를 저장하거나 기존 도서를 업데이트합니다.
   *
   * @param book 저장 또는 업데이트할 {@code Book} 엔터티.
   * @return 저장 또는 업데이트된 {@code Book} 엔터티.
   */
  Book saveOrUpdate(Book book);

  /**
   * 고유 식별자로 도서를 삭제합니다.
   *
   * @param id 삭제할 도서의 UUID.
   */
  void delete(UUID id);

  /**
   * {@code BookForm} 객체를 사용하여 새 도서를 저장하거나 기존 도서를 업데이트합니다.
   * <p>
   * 이 메서드는 {@code BookForm}에서 정보를 가져와 {@code Book} 엔터티를 저장 또는 업데이트하는 데 사용됩니다.
   * </p>
   *
   * @param bookForm 저장 또는 업데이트할 {@code BookForm} 객체.
   * @return 저장 또는 업데이트된 {@code Book} 엔터티.
   */
  Book saveOrUpdateBookForm(BookForm bookForm);

}
