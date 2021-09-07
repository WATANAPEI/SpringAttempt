package dev.wpei.springattempt.service;

import dev.wpei.springattempt.aws.s3.ObjectUploader;
import dev.wpei.springattempt.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageSaveService {
    private final ObjectUploader uploader;
    @Autowired
    public PageSaveService(ObjectUploader uploader) {
        this.uploader = uploader;
    }

    public void save(Page page) {
        uploader.upload(page);
        System.out.println("Upload finished.");
    }
}
