# android_text
An abstraction over androids string resources and kotlin strings with formatting support.
This library is just an experiment and not intended for production use.
It is missing main features that cannot be implemented with the current approach, like `Serializable` or `Parcelize` as well as equality.

## Usage
```kotlin
val world = text("World")
val helloWorld = text("Hello %s", world)
val stringRes = text(R.string.app_name)
val stringResWithArgs = text(R.string.app_name, x)
val joinedTexts = listOf("a", "b", "c").joinToText { text(it) }
```

## TODO
- [ ] Add support for plurals
- [ ] Add tests