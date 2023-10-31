package com.null0xff.project.library.dto;

import java.util.UUID;

/**
 * 도서의 양식 상세를 나타내는 레코드입니다.
 * <p>
 * 이 레코드는 주로 도서 생성 중 클라이언트로부터 정보를 수집하기 위해 사용됩니다.
 * </p>
 *
 * @author Ji Myoung Ha
 * @version 1.0
 * @since 2023-10-25
 */
public record BookForm(UUID id, String title) {

}
