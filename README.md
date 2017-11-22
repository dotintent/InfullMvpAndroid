MVP library for android
==================================

## Article
The whole library and its setup are described in [THIS](https://blog.infullmobile.com/mvp-cooked-the-infullmobile-way-25c01cf5cf52) medium article.

## Usage

#### Presenter
```kotlin
class SampleMvpActivityPresenter @Inject constructor(
        private val model: SampleMvpActivityModel,
        view: SampleMvpActivityView
) : Presenter<SampleMvpActivityView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        presentedView.displayedText = model.messageToBeDisplayed
    }
}
```

#### View
```kotlin
class SampleMvpActivityView @Inject constructor(
) : PresentedActivityView<SampleMvpActivityPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_mvp
    val textDisplay: TextView by bindView(R.id.textDisplay)

    override fun onViewsBound() {
        /* empty */
    }

    var displayedText: String
        get() = textDisplay.text.toString()
        set(value) {
            textDisplay.text = value
        }
}
```
#### Model
```kotlin

class SampleMvpActivityModel @Inject constructor(
    private val someUseCase: SomeUseCase
) {

    fun useSomeUseCase(param: String): Single<DomainObject> {
        return someUseCase
                    .parameter(param)
                    .perform()
    }
}
```

For working example see `sample` and `sample-kotlin` for more details.

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
    compile 'com.infullmobile.android:infullmvp-kotlin:1.1.14'
    testCcompile 'com.infullmobile.android:infullmvp-kotlin-basetest:1.1.14'
}
```

#### Java
```
dependencies {    
    compile 'com.infullmobile.android:infullmvp:1.1.14'
    testCompile 'com.infullmobile.android:infullmvp-basetest:1.1.14'
}
```

## InfullNavigation

We've made some classes to cut down navigation. 
Covers basics, in more complex apps you probably want an interface for testability

```
dependencies {    
    compile 'com.infullmobile.android.kotlin:navigation:1.1.14'    
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
