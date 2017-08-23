[InFullMvp] MVP lib for android
==================================

in your build.gradle:

```
repositories {
    maven { url 'https://maven.infullmobile.com/public' }
}

````


### For Kotlin
```
dependencies {    
    compile 'com.infullmobile.android:infullmvp-kotlin:1.1.11'
    testCcompile 'com.infullmobile.android:infullmvp-kotlin-basetest:1.1.11'
}
```

### For Java
```
dependencies {    
    compile 'com.infullmobile.android:infullmvp:1.1.11'
    testCompile 'com.infullmobile.android:infullmvp-basetest:1.1.11'
}
```

## InfullNavigation

We've made some classes to cut down navigation.
```
dependencies {    
    compile 'com.infullmobile.android:navigation:1.1.11'    
}
```

[InFullMvp] Android Studio Template
==================================

For Mac:
--------
Just copy InFullMvp folders from android-studio-plugin to $ANDROID_STUDIO_FOLDER$/Contents/plugins/android/lib/templates/activities/

For Windows:
--------
Just copy InFullMvp folders from android-studio-plugin to $ANDROID_STUDIO_FOLDER$\plugins\android\lib\templates\activities\


Then you can use it in Android studio from New -> InFullMvp
![template-usecause.png](android-studio-plugin/template_usecause.png?raw=true)
