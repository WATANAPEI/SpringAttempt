package dev.wpei.springattempt.service;

import dev.wpei.springattempt.aws.s3.ObjectUploader;
import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageSaveService {
    private ObjectUploader uploader;
    private PageRepository repo;

    /**
     * Use PageSaveServiceBuilder, not constructor
     */
    @Autowired
    public PageSaveService(PageRepository repo){
        this.repo = repo;
    }
    public PageSaveService withS3() {
        this.uploader = new ObjectUploader();
        return this;
    }

    public void save(Page page) {
        if(uploader == null && repo == null) {
            throw new IllegalStateException("Save destination must be specified.");
        }
        if(uploader != null) {
            uploader.upload(page);
            System.out.println("S3 upload finished.");
        }
        if(repo != null) {
            repo.save(page);
            System.out.println("File save finished.");
        }

    }
}
