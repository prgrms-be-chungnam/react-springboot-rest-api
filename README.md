# CRUD를 이용한 상품 관리 API 프로젝트

## 프로젝트 배경

- 클라이언트는 작은 Local Cafe `Grids & Circles`를 운영하고 있습니다.
- 클라이언트는 온라인 웹 사이트를 통해 `Coffee Bean Package`에 대한 고객의 주문을 받고, 관리하고자 합니다.
- 클라이언트는 매일 **작일 오후 2시**부터 **금일 오후 2시**까지의 주문을 한번에 처리하고자 합니다.

## 프로젝트 개요

### 요구사항

- `Coffee Bean Package`에는 총 4개의 상품이 존재하며, 추후 확장이 가능헤야 합니다.
  - Colombia Nariño
  - Brazil Serra do Caparaó
  - Columbia Quindío (White Wine Fermented)
  - Ethiopia Sidamo
- 주문을 한번에 처리(묶음 처리) 할 수 있어야 합니다.
- 별도의 회원관리 기능은 없으며, email로 고객을 구분해야 합니다.
- 하나의 email에 대한 여러 건의 주문은 하나로 합칠 수 있어야 합니다.
- 고객에게 주문 발송에 대한 안내가 제공되어야 합니다.

### 사용 기술

#### Server

- Framework: Spring Boot 3.1.2
- Database: MariaDB 10.6

##### Dependencies

- Apache Commons DbUtils
- Bootstrap (WebJar)
- MariaDB Java Client
- Project Lombok
- Spring Boot Starter JDBC
- Spring Boot Starter Thymeleaf
- Spring Boot Starter Web

#### Client

- Library: React

### 환경 변수

#### Server

- 데이터베이스 설정
  - [`.env.properties`](server/src/main/resources/.env.properties) 파일을 `env.properties`로 복사한 한 뒤, 다음과 같이 파일을 수정합니다.
    ```properties
    DB_DATABASE = [MariaDB 서버 IP]:[포트]/[데이터베이스]
    DB_USER     = [MariaDB 사용자]
    DB_PASSWORD = [MariaDB 비밀번호]
    ```