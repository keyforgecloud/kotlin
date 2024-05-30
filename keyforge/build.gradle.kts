/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("keyforge.kotlin-application-conventions")

    id("maven-publish")
}

group = "cloud.keyforge"
version = "0.0.1"

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":common"))
}

publishing {
    repositories {
        maven {
            name = "flyte-repository"
            url = uri(
                "https://repo.flyte.gg/${
                    if (version.toString().endsWith("-SNAPSHOT")) "snapshots" else "releases"
                }"
            )
            credentials {
                username = System.getenv("MAVEN_NAME") ?: property("mavenUser").toString()
                password = System.getenv("MAVEN_SECRET") ?: property("mavenPassword").toString()
            }
        }
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = group.toString()
                artifactId = "keyforge"
                version = version.toString()

                from(components["java"])
            }
        }
    }
}