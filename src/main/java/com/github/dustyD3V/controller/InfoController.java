package com.github.dustyD3V.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Value("${task.allowMultiTasks}")
    private boolean multiTasksEnabled;

    @GetMapping("/info/dburl")
    String getDbUrl() {
        return dataSourceProperties.getUrl();
    }

    @GetMapping("/info/multitasks")
    boolean isMultiTasksEnabled() {
        return multiTasksEnabled;
    }
}
