package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.service.PageSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
public class PageController {
    private final PageSaveService pageSaveService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public PageController(PageSaveService pageSaveService) {
        this.pageSaveService = pageSaveService;
    }

    @GetMapping("/pages")
    public Page pages() {
        Page page = new Page();
        page.setPrefecture("http://example.com/test");
        page.setFrom("this page is test.");
        return page;
    }

    @PostMapping("/")
    public String savePage(@RequestBody SavePageRequest request) {
        Page page = new Page();
        page.setPrefecture(request.getUrl());
        page.setFrom((request.getContent()));
        page.setCreatedAt(LocalDateTime.now());
        pageSaveService.save(page);
        return "saved: " + request.getUrl();
    }

}
