grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile('org.apache.cxf:cxf-rt-frontend-jaxws:2.3.0') {
            excludes 'spring-web'
        }
        compile('org.apache.cxf:cxf-rt-frontend-jaxrs:2.3.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core'
        }
        compile('org.apache.ws.security:wss4j:1.6.2')
        compile('org.apache.cxf:cxf-rt-ws-security:2.3.0') {
            excludes 'spring-web'
        }
        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
    plugins {
        test ":spock:0.5-groovy-1.7"
        test ":code-coverage:1.2.2"
        test ":codenarc:0.12"
    }
}

codenarc.ruleSetFiles = [
        'rulesets/basic.xml',
        'rulesets/braces.xml',
        'rulesets/concurrency.xml',
        'rulesets/design.xml',
        'rulesets/exceptions.xml',
        'rulesets/formatting.xml',
        'rulesets/grails.xml',
        'rulesets/imports.xml',
        'rulesets/jdbc.xml',
        'rulesets/junit.xml',
        'rulesets/logging.xml',
        'rulesets/naming.xml',
        'rulesets/security.xml',
        'rulesets/serialization.xml',
        'rulesets/size.xml',
        'rulesets/unnecessary.xml',
        'rulesets/unused.xml'].join(',').toString()