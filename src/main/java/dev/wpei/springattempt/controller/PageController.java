package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.service.PageSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
public class PageController {
    @Autowired
    PageSaveService pageSaveService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/pages")
    public Page pages() {
        Page page = new Page();
        page.setUrl("http://example.com/test");
        page.setContent("this page is test.");
        return page;
    }

    @PostMapping("/")
    public String savePage(SavePageRequest request) {
        Page page = new Page();
        page.setUrl(request.getUrl());
        page.setContent((request.getContent()));
        pageSaveService.save(page);
        return "saved: " + request.getUrl();
    }

}
