plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.first"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.modelmapper:modelmapper:2.3.8")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java:8.0.32")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    implementation ("com.auth0:java-jwt:3.18.2")
    // implementation ("org.springframework.boot:spring-boot-starter-security")
    // testImplementation ("org.springframework.security:spring-security-test")
    // implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    implementation ("io.jsonwebtoken:jjwt:0.9.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
