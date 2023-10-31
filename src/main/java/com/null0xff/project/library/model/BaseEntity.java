package com.null0xff.project.library.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

/**
 * 라이브러리 애플리케이션의 기본 엔터티를 나타냅니다.
 * <p>
 * 이 클래스는 유니버설 유니크 식별자(UUID)가 필요한 라이브러리 애플리케이션의 모든 엔터티 모델의 슈퍼클래스로서의 역할을 합니다. 다양한 엔터티 간에 공유되는 공통 속성과
 * 동작을 캡슐화합니다.
 * </p>
 * <p>
 * {@code MappedSuperclass} 주석은 이 클래스의 속성이 엔터티 서브클래스의 데이터베이스 테이블에 매핑된다는 것을 나타냅니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @since 2023-10-25
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

  /**
   * 엔터티를 위한 유니버설 유니크 식별자입니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

}
