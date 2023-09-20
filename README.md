# react-springboot-rest-api


# 주제 : 인터파크 티켓

## 1. 전체 요구 사항 분석

- 회원 가입
- 로그인
- 공연 조회
- 공연 예매 (좌석 선택 → 예매자 및 배송 정보 확인 → 결제하기)
- 마이 페이지

## 2. 도메인 분리

- 회원 (users)
- 공연 (shows)
- 공연장 (theater)
- 예매 (books)

## 3. 도메인 상세

### A. REST API

| Name      | Method | API Path        |
| --------- | ----   | ----------------|
| 회원 가입 | POST | /api/users/signup |
| 로그인    | POST | /api/users/signin |
|/          |      |                   |
| 공연 등록 | POST | /api/shows        |
| 공연 조회 | GET  | /api/shows/{id}   |
|/          |      |                   |
| 예매      | POST | /api/book         |

### B. DB 설계

![readme_db](./readme_db.png)

### C. 클래스 다이어그램

???
