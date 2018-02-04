[![CircleCI](https://circleci.com/gh/sporttotal-tv/toothpick-kotlin-extensions.svg?style=svg)](https://circleci.com/gh/sporttotal-tv/toothpick-kotlin-extensions)
[![](https://jitpack.io/v/sporttotal-tv/toothpick-kotlin-extensions.svg)](https://jitpack.io/#sporttotal-tv/toothpick-kotlin-extensions)


# Toothpick Kotlin extensions
Kotlin sprinkles over Toothpick dependency injection library  

define your modules like this:

```kotlin
module {
    bind<Repository>(DataBaseRepository::class)
    bindInstance<Scheduler>(DefaultScheduler())
    bindProviderInstance<Api>{ RestApi() }
}
```

# Details
## defining modules
Instead of 
```kotlin
Module().apply {
    // bindings
}
```
use a method and a lambda
```kotlin
module {
    // bindings
}
```

## binding to classes

Instead of writing

```kotlin
   module.bind(Repository::class.java).to(DbRepository::class.java)       
```

Use generics 

```kotlin
   module.bind<Repository>().to(DbRepository::class.java)  
```


Or write it in one instruction and use the Kotlin `KClass` instead of Java `Class` type
 
```kotlin
   module.bind<Repository>(DataBaseRepository::class)
```


## binding to instances

Instead of writing

```kotlin    
   module.bind(Scheduler::class.java).toInstance(DefaultScheduler())
   
```

Use generics:

```kotlin  
    bindInstance<Scheduler>{ DefaultScheduler() }   
```


## binding to providers

```kotlin
   module.bind(Api::class.java).toProviderInstance(ApiProvider())
```

use type inference (as provider is already generic):

```kotlin
    bindProviderInstance(ApiProvider())
```

and you can even directly pass the lambda creating the instance so no need to implement provider

```kotlin
    bindProviderInstance<Api>{ RetrofitApi() }
```


## Gradle

```groovy
repositories {
    maven {url "https://jitpack.io"}
}

compile 'com.github.sporttotal-tv:toothpick-kotlin-extensions:master-SNAPSHOT'	

```


