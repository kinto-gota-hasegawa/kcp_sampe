# Function Recordable Kotlin Compiler Plugin

A Kotlin Compiler Plugin that automatically logs function execution with a "function name starts" message for functions annotated with `@Recordable`.

## Overview

This repository contains an experimental Kotlin Compiler Plugin that adds logging functionality to your Kotlin functions. When a function is annotated with `@Recordable`, the plugin automatically injects logging code that prints when the function starts executing.

## Features

- Automatic logging of function execution
- Simple annotation-based configuration
- Zero runtime overhead when not using the annotation

## Usage

1. Add the plugin to your project's build.gradle.kts:

```kotlin
plugins {
    id("com.github.kintogotahasegawa.recordable") version "0.0.1"
}
```

2. Annotate your functions with `@Recordable`:

```kotlin
@Recordable
fun myFunction() {
    // Your function implementation
}
```

When `myFunction()` is called, it will automatically log:
```
myFunction starts
```

## Requirements

- Kotlin 1.8.0 or higher
- Gradle 7.0 or higher

## Installation

Add the following to your project's `settings.gradle.kts`:

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
