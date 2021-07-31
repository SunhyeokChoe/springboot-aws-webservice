package com.sunhyeokchoe.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

/*
 * build.gradle에 추가한 머스태치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때
 * 경로 및 확장자는 다음과 같이 자동으로 지정된다.
 * 경로: src/main/resources/templates,
 * 확장자: .mustache
 * 즉 여기선 "index"를 반환하므로 src/main/resources/templates/index.mustache로 전환되어
 * View Resolver가 처리하게 된다.
 */