package com.sunhyeokchoe.book.springboot.web;

import com.sunhyeokchoe.book.springboot.services.posts.PostsService;
import com.sunhyeokchoe.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/Posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
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
