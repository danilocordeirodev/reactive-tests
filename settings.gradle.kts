rootProject.name = "react-tests"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("springboot", "3.2.4")
            version("springbootManagement", "1.1.4")
            version("kotlin", "1.9.23")
            version("jooqPlugin", "9.0")
            version("flywayPlugin", "9.22.3")
            version("caffeine", "3.1.8")
            version("log4j", "2.23.1")
            version("flyway", "10.11.0")
            version("r2dbcSpi", "1.0.0.RELEASE")
            version("r2dbcPool", "1.0.1.RELEASE")
            version("r2dbcPostgresql", "1.0.5.RELEASE")
            version("postgresql", "42.7.1")
        }
    }
}