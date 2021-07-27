package com.sunhyeokchoe.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; // [#1]

public class AliveResponseDtoTest {
    @Test
    public void test_lombok_functionality() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        AliveResponseDto dto = new AliveResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // [#2], [#3]
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/*
 * [#1] assertj
 *   - Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용했다.
 *   - assertj 역시 Junit에서 자동으로 라이브러리 등록을 해준다.
 *   - assertj의 장점
 *      A. CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다.
 *         - Junit의 assertThat을 쓰게 되면 is()와 같이 CoreMatchers 라이브러리가 필요하다.
 *      B. 자동완성이 좀 더 확실하게 지원된다.
 *         - IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약하다.
 *
 * [#1] assertThat
 *   - assertj라는 테스트 검증 라이브러리의 검증 메소드이다.
 *   - 검증하고 싶은 대상을 메소드 인자로 받는다.
 *   - 메서드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.
 *
 * [#2] isEqualTo
 *   - assertj의 동등 비교 메서드이다.
 *   - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공을 반환한다.
 */
