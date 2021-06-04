# MultiNavCompose <img src=".github/static/navigation.png" alt="logo" width="50px"/>
[![GitHub license](https://img.shields.io/github/license/jeziellago/compose-markdown?style=for-the-badge)](https://github.com/jeziellago/compose-markdown/blob/main/LICENSE) [![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg?style=for-the-badge)](https://ktlint.github.io/) [![Android API](https://img.shields.io/badge/api-21%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=21) ![JitPack](https://img.shields.io/jitpack/v/github/jeziellago/multinavcompose?color=blue&style=for-the-badge)

Android library for multi-module navigation built on top of Jetpack Navigation Compose.
> The goal of this library is to simplify the setup for multi-module navigation with [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation).

## Setup
Add `jitpack.io` url as maven repository:
```  
repositories {  
	...  
	maven { url 'https://jitpack.io' }  
}    
```  
Add dependency into `build.gradle`:
```groovy  
dependencies {  
    implementation 'com.github.jeziellago:multinavcompose:TAG'  
}  
```

## 1. Create a NavComposableModule
Make your composables internal and expose only a `NavComposableModule` for each module.
```kotlin  
// module :posts  
val postsNavModule = NavComposableModule { graph, navController ->  
    graph.composable(POSTS_ROUTE) {  
        PostsScreen(onClick = { postId ->  
            navController.navigate("$POST_DETAIL_ROUTE/$postId")  
        })  
    }  
}  
```
#### You also can have nested graphs:
```kotlin  
// module :posts  
val postsNavModule = NavComposableModule { graph, navController ->  
	graph.navigation(startDestination = POSTS_ROUTE, route = POSTS) { 
	    composable(POSTS_ROUTE) {  
	        PostsScreen(onClick = { postId ->  
	            navController.navigate("$POST_DETAIL_ROUTE/$postId")  
	        })  
	     }
	     ...
    }
}  
```

## 2. Register the NavComposeModule`s
### Single NavHost
Call `multiNavModules` and put all the NavComposeModule's.
> For single activity applications (and only a `NavHost`) you should register the NavComposeModule  in `onCreate` on Application.
```kotlin  
class MyApplication : Application() {  
  
    override fun onCreate() {  
        super.onCreate()  
        // Register all NavComposeModules  
        multiNavModules(homeNavModule, postsNavModule, postDetailNavModule)  
    }  
}  
```
### Multiple NavHost's
If you have multiple `NavHost`'s, a `key` is required on registering each of them:
```kotlin
// feed nav graph
multiNavModules(feedNavModule) { FEED_GRAPH }

// posts nav graph
multiNavModules(postsNavModule, postDetailNavModule) { POST_GRAPH }
```
## 3. Setup on NavHost
The `loadMultiNavComposables` loads the composables into `NavHost`.
### Single NavHost
```kotlin
NavHost(navController = navController, startDestination = HOME) {  
  loadMultiNavComposables(navController)  
}
```
### Multiple NavHost
If you have multiple `NavHost`'s, a `key` is required too (see `POSTS_GRAPH`).
```kotlin
NavHost(navController = navController, startDestination = POSTS_ROUTE) {  
  loadMultiNavComposables(navController, POSTS_GRAPH)  
}
```
# License
```  
Copyright (c) 2021 Jeziel Lago  
  
Permission is hereby granted, free of charge, to any person obtaining  
a copy of this software and associated documentation files (the  
"Software"), to deal in the Software without restriction, including  
without limitation the rights to use, copy, modify, merge, publish,  
distribute, sublicense, and/or sell copies of the Software, and to  
permit persons to whom the Software is furnished to do so, subject to  
the following conditions:  
  
The above copyright notice and this permission notice shall be  
included in all copies or substantial portions of the Software.  
  
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,  
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF  
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND  
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE  
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION  
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION  
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.  
```
