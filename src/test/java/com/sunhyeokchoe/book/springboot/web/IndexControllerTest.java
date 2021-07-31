package com.sunhyeokchoe.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test // 메인 페이지 로딩 테스트
    public void load_mainPage() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then: body 내 "TEST" 문자열이 존재하는 경우 테스트 성공
        assertThat(body).contains("TEST");
    }
}

/*
 * HTML도 결국은 규칙이 있는 문자열이다. TestRestTemplate를 통해 "/"로 호출했을 때
 * index.mustache에 포함된 코드들이 있는지 확인하면 된다.
 * 전체 코드를 다 검증할 필요는 없으니, "TEST" 문자열이 포함되어 있는지만 비교한다.
 */