package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.dto.SavePageRequestDto;
import dev.wpei.springattempt.service.PageFetchService;
import dev.wpei.springattempt.service.PageSaveService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1")
public class PageController {
    private final PageSaveService pageSaveService;
    private final PageFetchService pageFetchService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public PageController(PageSaveService pageSaveService, PageFetchService pageFetchService) {
        this.pageFetchService = pageFetchService;
        this.pageSaveService = pageSaveService;
    }

    @GetMapping("/pages")
    public Page getPages() {
        Page page = new Page();
        page.setPrefecture("http://example.com/test");
        page.setFrom("this page is test.");
        return page;
    }

    /**
     *
     * curl -vG "http://localhost:8080/api/v1/page" --data-urlencode "prefecture=千葉県"
     *
     * @param prefecture
     * @return
     */
    @GetMapping("/page")
    public Page getPage(@RequestParam @NonNull String prefecture) {
        Page page = pageFetchService.getPage(prefecture);
        System.out.println(page);
        return page;
    }

    /**
     * curl -v -X POST -H "Content-Type: application/json" --data '{"url":"http","content":"aafds", "id":"3324"}' "http://lcaolhost:8080/api/v1/page"
     * @param request
     * @return
     */
    @PostMapping("/page")
    public String savePage(@RequestBody SavePageRequestDto request) {
        Page page = new Page();
        page.setPrefecture(request.getUrl());
        page.setFrom((request.getContent()));
        page.setCreatedAt(LocalDateTime.now());
        pageSaveService.save(page);
        return "saved: " + request.getUrl();
    }

}
