grails.project.work.dir = "target/work"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    //test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        jcenter()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        runtime "org.postgresql:postgresql:9.2-1004-jdbc4", {
            export = false
        }
    }

    plugins {
        runtime ":hibernate4:4.3.5.3", {
            export = false
        }

        build ":tomcat:7.0.53",
              ":release:3.0.1",
              ":rest-client-builder:1.0.3", {
            export = false
        }

        test ":code-coverage:1.2.7", {
            export = false
        }

        compile ":postgresql-extensions:4.2.0", {
            excludes "hibernate"
        }
    }
}