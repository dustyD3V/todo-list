package com.github.dustyD3V.controller;

import com.github.dustyD3V.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {
    private final DataSourceProperties          dataSourceProperties;
    private final TaskConfigurationProperties.Template template;

    InfoController(DataSourceProperties dataSourceProperties, TaskConfigurationProperties.Template template) {
        this.dataSourceProperties = dataSourceProperties;
        this.template = template;
    }

    @GetMapping("/info/dburl")
    String getDbUrl() {
        return dataSourceProperties.getUrl();
    }

    @GetMapping("/info/multitasks")
    boolean isMultiTasksEnabled() {
        return template.isAllowMultiTasks();
    }
}
