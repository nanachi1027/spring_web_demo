package org.example.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: Mae
 * @Date: 2021/2/18 4:08 上午
 */

@Slf4j
@ApiIgnore
@Controller
public class MainController {

    @RequestMapping(value = {"/"})
    public String index() {
        return "index.html";
    }
}
