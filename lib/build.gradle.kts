plugins {
	java
    jacoco
}

val group = "com.github.sporttotal-tv"

dependencies {

    compile("org.jetbrains.kotlin:kotlin-stdlib:1.2.10")
    compile("com.github.stephanenicolas.toothpick:toothpick-runtime:1.1.1")
    compile("com.github.stephanenicolas.toothpick:toothpick-testing:1.1.1")

    testCompile("org.mockito:mockito-all:1.9.5")
    testCompile("junit:junit:4.12")
    testCompile("org.amshove.kluent:kluent:1.27")

}

