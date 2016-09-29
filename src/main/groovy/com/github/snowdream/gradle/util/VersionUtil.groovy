package com.github.snowdream.gradle.util

import java.util.jar.JarEntry
import java.util.jar.JarFile

/**
 * Created by snowdream on 16-9-29.
 */
class VersionUtil {
    /**
     * getMajorVersionFromJar
     * @param path
     * @return
     */
    public static int getMajorVersionFromJar(String path) {
        JarFile jarFile = new JarFile(path);
        Enumeration enu = jarFile.entries();
        String classVersion = "";

        while (enu.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) enu.nextElement();
            String filename = jarEntry.getName();

            if (filename == null || filename.isEmpty() || !filename.endsWith(".class")) continue;

            System.out.print(filename + "\n");


            DataInputStream dis = new DataInputStream(jarFile.getInputStream(jarEntry));

            int magic = dis.readInt();
//            if (magic != 0xcafebabe) {
//                System.out.println(filename + " is not a java class!");
//            }

            int minor = dis.readUnsignedShort();
            int major = dis.readUnsignedShort();
            classVersion = major + "." + minor;
            System.out.println("classVersion: " + classVersion);

            dis.close();

            return major;
        }

        return -1;
    }
}
