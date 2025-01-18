pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Todo"
include(":app")
include(":core:data")
include(":core:common")
include(":core:database")
include(":core:domain")
include(":core:model")
include(":core:ui")
include(":feature:home")
include(":feature:splash")
include(":feature:addEditTodo")
include(":core:designSystem")
include(":core:recivers")
