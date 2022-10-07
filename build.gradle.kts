plugins {
    application
    java
    jacoco
    pmd
}

application {
    mainClass.set("game/ui/MasterMindUI")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    runtimeOnly("org.junit.platform:junit-platform-console:1.2.0")
}

sourceSets {
    main {
        java.srcDirs("src")

    }
    test {
        java.srcDirs("test")
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {}
}

defaultTasks("clean", "test")
