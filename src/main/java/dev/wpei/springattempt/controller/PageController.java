package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import dev.wpei.springattempt.dto.SavePageRequestDto;
import dev.wpei.springattempt.repository.StateOfEmergencyRepository;
import dev.wpei.springattempt.service.PageSaveService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PageController {
    private final PageSaveService pageSaveService;
    private final StateOfEmergencyRepository stateOfEmergencyRepository;

    @Autowired
    public PageController(PageSaveService pageSaveService, StateOfEmergencyRepository stateOfEmergencyRepository) {
        this.pageSaveService = pageSaveService;
        this.stateOfEmergencyRepository = stateOfEmergencyRepository;
    }

    /**
     *
     * curl -vG "http://localhost:8080/api/v1/page" --data-urlencode "prefecture=千葉県"
     *
     */
    @GetMapping("/page")
    public LocalStateOfEmergency getPage(@RequestParam @NonNull String prefecture) {
        LocalStateOfEmergency localStateOfEmergency = stateOfEmergencyRepository.get(prefecture);
        return localStateOfEmergency;
    }

}
