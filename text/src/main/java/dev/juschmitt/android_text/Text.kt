package dev.juschmitt.android_text

import android.content.Context

typealias Text = (Context) -> String

fun text(value: Int, vararg args: Text): Text = { context ->
    if (args.isEmpty()) context.getString(value) else context.getString(value, *args.format(context))
}

fun text(value: String, vararg args: Text): Text = { context ->
    if (args.isEmpty()) value else value.format(*args.format(context))
}

private fun Array<out Text>.format(context: Context): Array<out String> =
    map { it(context) }.toTypedArray()

fun joinText(separator: String = ",", vararg texts: Text): Text = { context ->
    texts.joinToString(separator) { it(context) }
}

fun <T> Iterable<T>.joinToText(separator: String = ",", transform: (T) -> Text): Text {
    val texts = map(transform)
    return joinText(separator, *texts.toTypedArray())
}

operator fun Text.plus(other: Text): Text = joinText(separator = "", this, other)
