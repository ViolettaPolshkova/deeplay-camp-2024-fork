plugins {
    id("java")
}

group = "io.deeplay.camp"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation(project(":reversi-server:model"))
    
}

tasks.test {
    useJUnitPlatform()
}