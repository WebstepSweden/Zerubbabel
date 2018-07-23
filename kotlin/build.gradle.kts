plugins {
    kotlin("jvm") version "1.2.50"
}

dependencies {
    compile(kotlin("stdlib"))
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.8")
}

repositories {
    jcenter()
}
