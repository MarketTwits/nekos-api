
# Kotlin network components
This is a Kotlin MultiPlatform library that provide wrapper for [Nekos API](https://nekosapi.com/) 
this addition to [ktor-client](https://github.com/ktorio/ktor) with gradle plugin to generate entities
 and api classes from OpenAPI (Swagger) specification file. Entities serialization done by
 [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization).

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Samples](#samples)
- [Contributing](#contributing)


## Features
- **OpenAPI client code generation** - just configure plugin then use generated entities and api classes;
- **Support** https://api.nekosapi.com/v3/

## Requirements
- Gradle version 6.8+
- Kotlin 1.9.10

## Installation
root build.gradle  

```
Coming soon
```

## Usage


```kotlin
import dev.icerock.moko.network.generated.apis.*

fun main(args: Array<String>) {
  runBlocking {
        val result = async { onRandomJokePressed() }
        val neko = result.await()
        println(neko)
 }

}
suspend fun onRandomJokePressed() {
 println("start")
 val httpClient: HttpClient = HttpClient {
  install(Logging) {
   logger = CustomHttpLogger()
   level = LogLevel.INFO
  }
 }
 val nekoApi: ImagesApi = ImagesApi(
  json = Json {
   ignoreUnknownKeys = true
   coerceInputValues = true
  },
  httpClient = httpClient
 )
 val joke: Result<Unit> = runCatching { nekoApi.nekosapiImagesApiRandomImages(limit = 1) }
 joke.onSuccess { println("joke: $it") }
  .onSuccess { println("joke: $it") }
  .onFailure { println("error: ${it.message}") }
}
```

For the moko-network specification generator, you can enable safe enum properties generation mode.
To turn on the mode in `build.gradle` to a `spec` block add flag:

```
enumFallbackNull = true
```

The enabled mode will generate special wrapper `Safeable` for all properties with the enum type,
that which in a situation for an unexpected enum value will return null.


## Samples
More examples can be found in the [sample directory](sample).


## Contributing
All development (both new features and bug fixes) is performed in `develop` branch. This way `master` sources always contain sources of the most recently released version. Please send PRs with bug fixes to `develop` branch. Fixes to documentation in markdown files are an exception to this rule. They are updated directly in `master`.

The `develop` branch is pushed to `master` during release.

More detailed guide for contributers see in [contributing guide](CONTRIBUTING.md).


