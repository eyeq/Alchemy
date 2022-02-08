package eyeq.util

class CharSequenceExtensions {
    companion object {
        fun trimTrailingWhitespace(source: CharSequence?): CharSequence {
            if (source == null) return ""
            var i = source.length

            while (--i >= 0 && Character.isWhitespace(source[i])) {
            }
            return source.subSequence(0, i + 1)
        }
    }
}