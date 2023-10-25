package com.null0xff.project.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LibraryApplication은 'library' SpringBoot 프로젝트의 시작점 역할을 합니다.
 * <p>
 * 이 클래스는 SpringBoot 애플리케이션을 부트스트랩하고 내장 웹 서버를 시작하여 'library' 프로젝트의 서비스와 기능을 활용할 수 있게 합니다. main 메소드는
 * {@link LibraryApplication}을 주요 구성 클래스로 사용하여 SpringBoot 애플리케이션을 호출합니다.
 * </p>
 *
 * <h2>사용법</h2>
 * <pre>
 * java -jar library-0.0.1-SNAPSHOT.jar
 * </pre>
 * <p>
 * 시작한 후 애플리케이션의 서비스는 'library.project.null0xff.com'을 통해 접근 가능합니다.
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @see <a href="https://library.project.null0xff.com">library.project.null0xff.com</a>
 * @since 2023-10-25
 */
@SpringBootApplication
public class LibraryApplication {

  /**
   * SpringBoot 애플리케이션의 시작점 역할을 하는 main 메소드.
   *
   * @param args 애플리케이션에 전달된 명령 줄 인수.
   */
  public static void main(String[] args) {
    SpringApplication.run(LibraryApplication.class, args);
  }
}
