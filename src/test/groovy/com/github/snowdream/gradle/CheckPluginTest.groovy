package com.github.snowdream.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class CheckPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'com.github.snowdream.gradle'

        assertTrue(project.tasks.checkJavaVersion instanceof CheckTask)
    }
}
