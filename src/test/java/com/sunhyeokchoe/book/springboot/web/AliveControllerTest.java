package com.sunhyeokchoe.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.
        MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // [#1]
@WebMvcTest(controllers = AliveController.class) // [#2]
public class AliveControllerTest {

    @Autowired // [#3]
    private MockMvc mvc; // [#4]

    @Test
    public void returns_alive() throws Exception {
        String alive = "Im alive!";

        mvc.perform(get("/alive")) // [#5]
                .andExpect(status().isOk()) // [#6]
                .andExpect(content().string(alive)); // [#7]
    }
}

/*
 * [#1] @RunWith(SpringRunner.class)
 *   - 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다. (여기서는 SpringRunner 실행자 실행)
 *   - 스프링 부트 테스트와 JUnit 사이의 연결자 역할이다.
 *
 * [#2] @WebMvcTest
 *   - 여러 스프링 테스트 애노테이션 중, Web(Spring MVC)에 집중할 수 있는 애노테이션이다.
 *   - 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
 *   - 단, @Service, @Component, @Repository 등은 사용할 수 없다.
 *   - 여기서는 컨트롤러만 사용하기 때문에 선언한다.
 *
 * [#3] @Autowired
 *   - 스프링이 관리하는 Bean을 주입 받는다.
 *
 * [#4] @private MockMvc mvc
 *   - 웹 API를 테스트할 때 사용한다.
 *   - 스프링 MVC 테스트의 시작점이다.
 *   - 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
 *
 * [#5] mvc.perform(get("/alive"))
 *   - MockMvc를 통해 /alive 주소로 HTTP GET 요청을 한다.
 *   - 메서드 체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
 *
 * [#6] .andExpect(status().isOk())
 *   - mvc.perform의 결과를 검증한다.
 *   - HTTP Header의 Status를 검증한다. (HTTP Response Code)
 *   - 여기선 OK 즉, 200인지 아닌지 검증한다.
 *
 * [#7] .andExpect(content().string(alive))
 *   - mvc.perform의 결과를 검증한다.
 *   - 응답 본문의 내용을 검증한다.
 *   - Controller에서 "Im alive!"를 리턴하기 때문에 이 값이 알맞는지 검증한다.
 */