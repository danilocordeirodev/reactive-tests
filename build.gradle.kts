import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

plugins {
	id("org.springframework.boot") version libs.versions.springboot.get()
	id("io.spring.dependency-management") version libs.versions.springbootManagement.get()
	kotlin("jvm") version libs.versions.kotlin.get()
	kotlin("plugin.spring") version libs.versions.kotlin.get()
	kotlin("plugin.jpa") version libs.versions.kotlin.get()
	id("nu.studer.jooq") version libs.versions.jooqPlugin.get()
	id("org.flywaydb.flyway") version libs.versions.flywayPlugin.get()
}

group = "com.xama"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	//spring boot starter
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")

	//reactive database
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("io.r2dbc:r2dbc-spi:${libs.versions.r2dbcSpi.get()}")
	implementation("io.r2dbc:r2dbc-pool:${libs.versions.r2dbcPool.get()}")
	implementation("org.postgresql:r2dbc-postgresql:${libs.versions.r2dbcPostgresql.get()}")

	//kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	//flyway
	implementation("org.flywaydb:flyway-core:${libs.versions.flyway.get()}")
	implementation("org.flywaydb:flyway-database-postgresql:${libs.versions.flyway.get()}")

	// Add jOOQ dependencies
	implementation("org.jooq:jooq")
	implementation("org.jooq:jooq-meta")
	implementation("org.jooq:jooq-codegen")

	implementation("com.github.ben-manes.caffeine:caffeine:${libs.versions.caffeine.get()}")
	implementation("org.apache.logging.log4j:log4j:${libs.versions.log4j.get()}")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//database-for flyway migration and jooq stub generation
	runtimeOnly("org.postgresql:postgresql:${libs.versions.postgresql.get()}")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//jooq generation using postgres db
dependencies {
	jooqGenerator("org.postgresql:postgresql:42.5.4")
}

/* jooq and flyway setup */
val dbUrl = "jdbc:postgresql://localhost:5432/postgres"
val dbUser = "postgres"
val dbPassword = "pass123"
val dbDriver = "org.postgresql.Driver"

flyway {
	driver = dbDriver
	url = dbUrl
	user = dbUser
	password = dbPassword
	schemas = arrayOf("public")
	baselineOnMigrate = true
	table = "flyway_schema_history"
	locations = arrayOf("filesystem:$projectDir/src/main/resources/db/migration")
}

jooq {
	version.set("3.18.13")  // the default (can be omitted)
	edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)  // the default (can be omitted)
	configurations {
		create("main") {  // name of the jOOQ configuration
			generateSchemaSourceOnCompilation.set(true)  // default (can be omitted)

			jooqConfiguration.apply {
				logging = Logging.WARN
				jdbc.apply {
					driver = dbDriver
					url = dbUrl
					user = dbUser
					password = dbPassword
					properties.add(Property().apply {
						key = "ssl"
						value = "false"
					})
				}
				generator.apply {
					name = "org.jooq.codegen.DefaultGenerator"
					database.apply {
						name = "org.jooq.meta.postgres.PostgresDatabase"
						inputSchema = "public"
						forcedTypes.addAll(listOf(
							ForcedType().apply {
								name = "varchar"
								includeExpression = ".*"
								includeTypes = "JSONB?"
							},
							ForcedType().apply {
								name = "varchar"
								includeExpression = ".*"
								includeTypes = "INET"
							}
						))
					}
					generate.apply {
						isDeprecated = false
						isRecords = true
						isImmutablePojos = true
						isFluentSetters = true
					}
					target.apply {
						packageName = "com.xama.reacttests.generated"
						directory = "src/main/jooq"  // default (can be omitted)
					}
					strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
				}
			}
		}
	}

}