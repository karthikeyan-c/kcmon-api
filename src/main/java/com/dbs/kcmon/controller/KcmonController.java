package com.dbs.kcmon.controller;

import com.dbs.kcmon.element.Node;
import com.dbs.kcmon.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KcmonController {

    @Autowired
    MetricsService metricsService;

    @GetMapping("metrics")
    Node getMetrics() {
        return metricsService.getCurrentMetrics();
    }
}
