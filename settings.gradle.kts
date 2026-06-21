pluginManagement {
    repositories {
        // FIX: sem filtro de conteúdo — Google, Firebase e AGP precisam
        // de acesso irrestrito ao repositório google() para resolução de plugins
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LegoAR-Firebase"
include(":app")
