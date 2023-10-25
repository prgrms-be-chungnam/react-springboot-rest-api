package com.null0xff.project.library;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 서블릿 컨테이너에서 전통적인 WAR로 애플리케이션을 배포하기 위한 서블릿 초기화 클래스입니다.
 * <p>
 * 이 클래스는 {@code SpringBootServletInitializer}를 확장하여 서블릿 컨테이너에서 애플리케이션을 시작할 수 있게 해주며, 프로그래밍 방식으로 서블릿
 * 컨텍스트를 구성합니다. 이 구성에서는 {@code LibraryApplication}이 주요 Spring Boot 애플리케이션 클래스로 지정됩니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @see com.null0xff.project.library.LibraryApplication
 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer
 * @since 2023-10-25
 */
public class ServletInitializer extends SpringBootServletInitializer {

  /**
   * 애플리케이션을 구성합니다.
   * <p>
   * 이 메소드는 서블릿 컨텍스트 초기화를 위한 주요 Spring Boot 애플리케이션 클래스를 가리킵니다.
   * </p>
   *
   * @param application 스프링 애플리케이션 빌더입니다.
   * @return 구성된 애플리케이션 빌더를 반환합니다.
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(LibraryApplication.class);
  }

}
