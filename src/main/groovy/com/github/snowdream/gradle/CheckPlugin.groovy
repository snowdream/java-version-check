package com.github.snowdream.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin

class CheckPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('checkJavaVersion', type: CheckTask)
    }
}
