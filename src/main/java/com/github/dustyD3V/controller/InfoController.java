package com.github.dustyD3V.controller;

import com.github.dustyD3V.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {
    private final DataSourceProperties          dataSourceProperties;
    private final TaskConfigurationProperties   taskConfigurationProperties;

    InfoController(DataSourceProperties dataSourceProperties, TaskConfigurationProperties taskConfigurationProperties) {
        this.dataSourceProperties = dataSourceProperties;
        this.taskConfigurationProperties = taskConfigurationProperties;
    }

    @GetMapping("/info/dburl")
    String getDbUrl() {
        return dataSourceProperties.getUrl();
    }

    @GetMapping("/info/multitasks")
    boolean isMultiTasksEnabled() {
        return taskConfigurationProperties.isAllowMultiTasks();
    }
}
