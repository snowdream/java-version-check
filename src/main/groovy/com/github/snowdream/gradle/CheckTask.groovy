package com.github.snowdream.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckTask extends DefaultTask {
    String greeting = 'hello from CheckTask'

    @TaskAction
    def greet() {
        println greeting
    }
}
