package com.null0xff.project.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 라이브러리 애플리케이션에서 책 엔터티를 나타냅니다.
 * <p>
 * 이 클래스는 라이브러리의 책에 특정한 속성과 동작을 캡슐화합니다. {@code Book} 엔터티는 {@code BaseEntity}를 확장하며, 주 키로서의 유니버설 유니크
 * 식별자(UUID)를 상속받습니다.
 * </p>
 * <p>
 * {@code Entity} 주석은 이 클래스가 JPA 엔터티임을 나타내며, {@code Table} 주석은 엔터티와 연관된 데이터베이스 테이블 이름을 지정합니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @since 2023-10-25
 */
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  /**
   * 책의 제목입니다.
   */
  @Column(name = "title")
  private String title;
  
}
