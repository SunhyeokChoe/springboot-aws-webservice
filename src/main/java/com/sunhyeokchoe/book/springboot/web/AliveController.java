package com.sunhyeokchoe.book.springboot.web;

import com.sunhyeokchoe.book.springboot.web.dto.AliveResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.
RestController;

/* << RestController >>
 * 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
 * 예전에는 @ResponseBody를 각 메서드마다 선언했던 것을 한번에 사용할 수 있도록 해준다고 보면 된다.
 */
@RestController
public class AliveController {
    /* GetMapping
     * HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
     * 예전에는 @RequestMapping으로 사용되었다.
     * 이제 이 프로젝트는 /alive로 요청이 오면 문자열 "Im alive!"를 반환하는 기능을 가지게 된다.
     */
    @GetMapping("/alive")
    public String alive() {
        return "Im alive!";
    }

    @GetMapping("/alive/dto")
    public AliveResponseDto aliveDto(@RequestParam("name") String name, // [#1]
                                     @RequestParam("amount") int amount) {
        return new AliveResponseDto(name, amount);
    }
}
