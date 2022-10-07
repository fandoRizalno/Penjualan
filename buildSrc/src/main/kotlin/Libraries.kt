import org.gradle.api.artifacts.dsl.DependencyHandler
import dependencies.*

fun DependencyHandler.libraries(){
    androidX()
    materialDesign()
    test()
    koin("3.2.0-beta-1")
    lifeCycle("2.5.1")
    navGraph("2.4.2")
    glide("4.13.0")
    gson()
}