package com.github.dustyD3V;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public
class TaskConfigurationProperties {
    private boolean allowMultiTasks;

    public boolean isAllowMultiTasks() {
        return allowMultiTasks;
    }

    void setAllowMultiTasks(boolean allowMultiTasks) {
        this.allowMultiTasks = allowMultiTasks;
    }
}
