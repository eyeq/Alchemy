package eyeq.util

fun CharSequence.trimTrailingWhitespace(): CharSequence {
    var i = this.length - 1
    while (i >= 0 && Character.isWhitespace(this[i])) {
        i -= 1
    }

    return this.subSequence(0, i + 1)
}