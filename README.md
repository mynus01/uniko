
# Uniko [![](https://jitpack.io/v/mynus01/uniko.svg)](https://jitpack.io/#mynus01/uniko) ![](https://github.com/mynus01/uniko/actions/workflows/android_test.yml/badge.svg)


**Uniko** is a library that makes Android development organized and standardized.

## Installation
 
In your root gradle.build add Jitpack in the repositories tag:
```groovy
allprojects {  
  repositories {  
        maven { url 'https://jitpack.io' }  
  }
}
```

In your app gradle.build add the implementation inside the dependencies tag:
```groovy
dependencies {
    implementation 'com.github.mynus01:uniko:0.1.0-beta'
}
```

## License
Uniko is licensed under the [MIT](https://github.com/mynus01/uniko/blob/master/LICENSE) license.
