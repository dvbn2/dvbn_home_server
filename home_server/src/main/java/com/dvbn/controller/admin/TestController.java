package com.dvbn.controller.admin;

import com.dvbn.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dvbn
 * @title: TestController
 * @createDate 2023/9/16 21:41
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public Result<String> test() {
        return Result.success("test");
    }
}
