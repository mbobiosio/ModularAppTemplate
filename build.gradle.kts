import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import extensions.isNonStable

plugins {
    id(Plugins.ANDROID_APPLICATION) version (PluginVersion.AGP) apply false
    id(Plugins.ANDROID_LIBRARY) version (PluginVersion.AGP) apply false
    kotlin(Plugins.ANDROID) version (PluginVersion.KGP) apply false
    id(Plugins.AndroidxNavigation) version (PluginVersion.Navigation) apply false
    id(Plugins.Detekt) version (PluginVersion.Detekt)
    id(Plugins.BenManesVersions) version (PluginVersion.BenManesVersions)
}

subprojects {
    apply {
        plugin(Plugins.Detekt)
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt.html")
            }
        }
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}
