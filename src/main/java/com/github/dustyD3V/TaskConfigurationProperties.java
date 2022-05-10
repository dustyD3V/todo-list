package com.github.dustyD3V;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    public Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    @Configuration
    @ConfigurationProperties("template")
    public static class Template {
        private boolean allowMultiTasks;

        public boolean isAllowMultiTasks() {
            return allowMultiTasks;
        }

        public void setAllowMultiTasks(boolean allowMultiTasks) {
            this.allowMultiTasks = allowMultiTasks;
        }
    }
}
