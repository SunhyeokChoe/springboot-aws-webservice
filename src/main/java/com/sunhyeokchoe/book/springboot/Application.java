/*
 * 메인 클래스
 *
 */

package com.sunhyeokchoe.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정한다.
// SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS(Web Application Server) 실행
        /* 내장 WAS를 쓰는 이유?
         * 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 의미한다.
         * 이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진
         * Jar 파일(실행 가능한 Java 패키징 파일)로 실행하면 된다.
         *
         * 스프링 부트에서 내장 WAS 사용을 권장하는 이유?
         * 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문이다.
         * 외장 WAS를 쓴다고 하면 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야 하므로
         * 새로운 서버가 추가되면 모든 서버가 같은 WAS 환경을 구축해야만 한다.
         * 1대면 다행이지만, 30대의 서버에 설치된 WAS의 버전을 올린다고 한다면?
         * 실수할 여지도 많고 시간도 많이 든다.
         * 따라서 많은 회사에서 내장 WAS를 사용하도록 전환하고 있다.
         */
        SpringApplication.run(Application.class, args);
    }
}
