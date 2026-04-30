package com.rsproject.your_punchbread.admin_response;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/response")
public class AdminResponseController {
    private final AdminResponseService responseService;

    public AdminResponseController(AdminResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/update")
    public String updateResponse(@RequestBody AdminResponse newResponse) {
        responseService.updateResponse(newResponse.getResponseMessage(), newResponse.getResponsePhotoIndex());
        return "Admin response updated!";
    }

    @GetMapping("/current")
    public AdminResponse getCurrentResponse() {
        return responseService.getResponse();
    }

    @DeleteMapping("/delete")
    public String deleteResponse() {
        responseService.deleteResponse();
        return "The response has been deleted!";
    }

    @PostMapping("reset-all-stats")
    public String resetStats() {
        responseService.resetAllStats();
        return "The response has been reset!";
    }
}
