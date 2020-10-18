package com.cheenath.rest;
import com.cheenath.data.App;
import com.cheenath.data.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/app")
public class AppController {
    private final String APP_NAME="app-";
    private final int PORT_NUMBER_BASE = 8080;
    private final String JAVA_REPO_URL = "https://github.com/ajaycheenath/java-simple-rest-bootstrap.git";

    @Autowired
    private AppRepository appRepository;

    @GetMapping
    public App getApp(@RequestParam(value = "appId") Long appId) {
        return appRepository.findById(appId).orElse(null);
    }

    @GetMapping(value ="/nextid")
    public Integer getNextAppId() {
        return appRepository.findMaxAppId() != null ? appRepository.findMaxAppId().intValue() + 1 : 1;
    }

    @GetMapping(value = "/list")
    public Iterable<App> getAllApps() {
        return appRepository.findAll();
    }

    @PostMapping
    public App addApp(@RequestParam(value = "repo") String repo) {
        int nextAppId = appRepository.findMaxAppId() != null ? appRepository.findMaxAppId().intValue() + 1 : 1;
        final int PORT_NUMBER = PORT_NUMBER_BASE + nextAppId;
        final String openApiURL = String.format("http://localhost:%d/swagger-ui-custom.html", PORT_NUMBER);
        return appRepository.save(new App(nextAppId, APP_NAME + nextAppId, PORT_NUMBER, new Date(), repo, openApiURL));
    }

    @DeleteMapping
    public void deleteApp(@RequestParam(value = "appId") Long appId) {
        appRepository.deleteById(appId);
    }

}
