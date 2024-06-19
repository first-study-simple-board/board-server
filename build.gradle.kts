plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.first"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
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
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final") // Hibernate 최신 버전 추가
}

tasks.withType<Test> {
	useJUnitPlatform()
}