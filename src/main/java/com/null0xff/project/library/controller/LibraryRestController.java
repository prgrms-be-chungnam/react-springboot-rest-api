package com.null0xff.project.library.controller;

import com.null0xff.project.library.dto.BookForm;
import com.null0xff.project.library.model.Book;
import com.null0xff.project.library.service.LibraryService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LibraryRestController 클래스는 모든 책을 나열하고 특정 책의 세부 정보를 검색하는 것과 같은 도서관 관련 작업을 위한 RESTful API를 제공합니다.
 * <p>
 * 주요 엔드포인트 접두사는 "/api/v1/library"입니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @since 2023-10-25
 */
@RestController
@RequestMapping(value = "/api/v1/library")
public class LibraryRestController {

  private final LibraryService libraryService;

  /**
   * LibraryRestController의 새로운 인스턴스를 구성합니다.
   *
   * @param libraryService 도서관 데이터와 상호 작용하기 위한 {@link LibraryService}의 인스턴스.
   */
  public LibraryRestController(LibraryService libraryService) {
    this.libraryService = libraryService;
  }

  /**
   * 도서관에서 사용 가능한 모든 책의 목록을 검색합니다.
   *
   * @return {@link Book} 객체의 목록.
   */
  @RequestMapping(value = "/books")
  public List<Book> listBooks() {
    return libraryService.listAll();
  }

  /**
   * 식별자로 특정 책의 세부 정보를 검색합니다.
   *
   * @param id 책의 식별자.
   * @return 책 세부 정보를 나타내는 {@link Book} 객체.
   */
  @RequestMapping(value = "/book/{id}")
  public Book getBook(@PathVariable String id) {
    return libraryService.getById(UUID.fromString(id));
  }

  /**
   * 도서관에 새로운 책을 등록합니다.
   *
   * @param request 새로운 책의 세부 정보를 포함하는 {@link BookForm} 객체.
   * @return 작업의 성공 또는 실패를 나타내는 {@link ResponseEntity} 객체.
   */
  @RequestMapping(value = "/book")
  public Book newBook(@RequestBody BookForm request) {
    return libraryService.saveOrUpdateBookForm(request);
  }

  /**
   * 식별자를 사용하여 도서관에서 책을 삭제합니다.
   *
   * @param id 삭제할 책의 식별자.
   * @return 작업의 성공 또는 실패를 나타내는 {@link ResponseEntity} 객체.
   */
  @DeleteMapping(value = "/book/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    libraryService.delete(UUID.fromString(id));
    return ResponseEntity.ok().build();
  }
  
}
