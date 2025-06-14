plugins {
    id("java")
    id("application")
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.named<JavaExec>("run") {
    mainClass.set("org.example.Pets")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.Pets"
    }
}

tasks.test {
    useJUnitPlatform()
}