package com.github.snowdream.gradle

import com.github.snowdream.gradle.util.VersionUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

class CheckTask extends DefaultTask {
    @TaskAction
    def check() {
        println 'Jar information:'
        println project.jarconf.file
        println project.jarconf.dir
        println project.jarconf.minmajorversion

        if (!project.jarconf.minmajorversion) {
            throw new GradleException("jarconf.minmajorversion should not be empty.");
        }else{
            checkMinMajorVersion(project.jarconf.minmajorversion)
        }

        if (project.jarconf.file) {
            checkFileVersion(project.jarconf.file)
        }

        if (project.jarconf.dir) {
            checkDirVersion(project.jarconf.dir)
        }
    }

    def checkFileVersion(def path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new GradleException("The file dose not exist: " + file);
        };

        if (!file.canRead()) {
            throw new GradleException("The file can not be read: " + file);
        };

        if (!file.isFile()) {
            throw new GradleException("It is not a file: " + file);
        };

        if (!(path as String).endsWith(".jar")) {
            throw new GradleException("Invalid Param. jarconf.file should be a jar file path: " + file);
        };


        int major = VersionUtil.getMajorVersionFromJar(path);
        if (major > project.jarconf.minmajorversion) {
            println project.jarconf.file
            throw new GradleException('Unsupported major.minor version ' + major +
                    "\n from " + file);
        }
    }


    def checkDirVersion(def path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new GradleException("The file dose not exist: " + file);
        };

        if (!file.canRead()) {
            throw new GradleException("The file can not be read: " + file);
        };

        if (!file.isDirectory()) {
            throw new GradleException("It is not a directory: " + file);
        };

        String[] jars = file.list(new FilenameFilter() {
            @Override
            boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        })

        if (jars == null || jars.length == 0){
            return;
        }

        for (String jar : jars){
            checkFileVersion(path+ File.separator + jar);
        }
    }

    def checkMinMajorVersion(def major) {
        IntRange range = new IntRange(45,53);
        if (!range.contains(major)){
            throw new GradleException("Invalid jarconf.minmajorversion: " + project.jarconf.minmajorversion);
        }
    }
}
