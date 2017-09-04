MVP library for android
==================================

## Usage

Please see `sample` and `sample-kotlin` for how we are usually using it.

## Integrate

in your build.gradle:

```
repositories {
    maven { url 'https://maven.infullmobile.com/public' }
}

````


#### Kotlin
```
dependencies {    
    compile 'com.infullmobile.android:infullmvp-kotlin:1.1.11'
    testCcompile 'com.infullmobile.android:infullmvp-kotlin-basetest:1.1.11'
}
```

#### Java
```
dependencies {    
    compile 'com.infullmobile.android:infullmvp:1.1.11'
    testCompile 'com.infullmobile.android:infullmvp-basetest:1.1.11'
}
```

## InfullNavigation

We've made some classes to cut down navigation. 
Covers basics, in more complex apps you probably want an interface for testability

```
dependencies {    
    compile 'com.infullmobile.android:navigation:1.1.11'    
}
```

Android Studio Template
==================================

This will integrate with `New` menu to give you quick generator for classes for this library.
![template-usecause.png](android-studio-plugin/template_usecause.png?raw=true)

Installation
--------
Copy all directories from `android-studio-plugin` to specific `templates/activites` subfolder of your installation.

#### Mac:
 
````
$ANDROID_STUDIO_FOLDER$/Contents/plugins/android/lib/templates/activities/
````

#### Windows: 
````
$ANDROID_STUDIO_FOLDER$\plugins\android\lib\templates\activities\
````

#### Linux:
Just copy InFullMvp folders from android-studio-plugin to 
````
$ANDROID_STUDIO_FOLDER$/plugins/android/lib/templates/activities
````
Where `ANDROID_STUDIO_FOLDER` unusually is
 
`/opt/android-studio/` if you install from a PPA

or
 
`~/bin/android-studio.d/` if you install by hand for your user.

or `~/Downloads/android-studio-{version_info}` if you were lazy after a download.