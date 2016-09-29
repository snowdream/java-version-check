package com.github.snowdream.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class CheckTaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('checkJavaVersion', type: CheckTask)
        assertTrue(task instanceof CheckTask)
    }
}
