# java-version-check
   
a gradle plugin to avoid the error: "java.lang.UnsupportedClassVersionError: Unsupported major.minor version **"      

## Usage
```
buildscript {
    repositories {
        jcenter()
        maven { url "https://plugins.gradle.org/m2/" }
    }
    
    dependencies {
        classpath 'com.github.snowdream.gradle:java-version-check:0.1'
    }
}

apply plugin: "java-version-check"

jarconf{
    file "file path for jar"
    dir "dir path which contains jar"
    minmajorversion 50
}
```
## Run
```
gradle checkJavaVersion
```

### Contacts
* Email：yanghui1986527#gmail.com
* QQ Group: 529327615      


## License
```
Copyright (C) 2016 Snowdream Mobile <yanghui1986527@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
