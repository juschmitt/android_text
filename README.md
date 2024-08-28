# android_text
An abstraction over androids string resources and kotlin strings with formatting support

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