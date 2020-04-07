# Setup

## Creating Project

1. Launch `Intellij IDEA`
2. Choose Gradle Java Project.  

![Intellij Project Creation Wizard 1][create_project_step1]

3. Enter Project Name and Package Name

![Intellij Project Creation Wizard 2][create_project_step2]

## Installing Gradle CommandLine Tool

1. __Install (or) Configure `JDK 8` __

    - Gradle Requires JDK for it's Execution
     
    ```bash
    ❯ /usr/libexec/java_home -V
        Matching Java Virtual Machines (3):
          13.0.2, x86_64:	"Java SE 13.0.2"	/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home
          13.0.2, x86_64:	"OpenJDK 13.0.2"	/Library/Java/JavaVirtualMachines/openjdk-13.0.2.jdk/Contents/Home
          1.8.0_241, x86_64:	"Java SE 8"	/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home
    ❯ /usr/libexec/java_home -v 1.8
        /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home    
    ❯ export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
    ❯ java -version
        java version "1.8.0_151"
        Java(TM) SE Runtime Environment (build 1.8.0_151-b12)
        Java HotSpot(TM) 64-Bit Server VM (build 25.151-b12, mixed mode)
    ```
    
2. Install `Gradle` via Package Manager (or) Manually
    - Via Package Manager
        ```bash
         ❯ brew install gradle
        ```
     - Via __https://gradle.org/releases/__
        - Comes in __2 flavours__  
          - Binary-only (bin).                                        
          - Complete (all) with docs and sources.
        ```bash
           ❯ mkdir /opt/gradle
           ❯ unzip -d /opt/gradle gradle-6.3-bin.zip
           ❯ ls /opt/gradle/gradle-6.3
            LICENSE  NOTICE  bin  README  init.d  lib  media
        ```
3. Verify Installation 
   
   ```bash
    ❯ gradle -v
        ------------------------------------------------------------
        Gradle 6.3
        ------------------------------------------------------------
   ```
   
## Installing Gradle Wrapper via Gradle CommandLine Tool

1. Install `Gradle Wrapper` for the Project

   ```bash
    ❯ gradle wrapper 
   ```
   
   Gradle Wrapper gets created like below: 
   ![Gradle ArcheType - Java Application][gradle_wrapper]
   
## Initialize `JAVA APPLICATION` project using gradle wrapper.


```bash
karthickchinnathambi@Karthicks-MBP dagger-sample % ./gradlew init --type java-application --test-framework junit-jupiter

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Project name (default: dagger-sample): dagger-sample
Source package (default: dagger.sample): com.ckarthickit.dagger.sample

> Task :init
Get more help with your project: https://docs.gradle.org/6.3/userguide/tutorial_java_projects.html

BUILD SUCCESSFUL in 23s
2 actionable tasks: 1 executed, 1 up-to-date
```   

Gradle Init Will ask for Project Name and package Name to setup a `gradle command-line Java Application` Project.

![Gradle Init - Wizard][gradle_init]

## Build & Run the Application

1. Execute `assemble` Task

  ```bash
    ./gradlew assemble
  ```
  > Check `build` folder for generated artifacts.
  
2. Execute `run` Task

  ```bash
    ./gradlew run
  ```
   



---
[create_project_step1]: docs/create_project_step1.png
[create_project_step2]: docs/create_project_step2.png
[gradle_wrapper]: docs/gradle_wrapper.png
[gradle_init]: docs/gradle_init.png

   