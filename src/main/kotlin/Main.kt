import java.io.File

fun main() {
    val inStream = File("Main.kt").inputStream()
    val code = inStream.bufferedReader().use { it.readText() }
    println(code)
    println("Are { } fine? " + areBracketsFine(code, '{', '}').toString())
    println("Are ( ) fine? " + areBracketsFine(code, '(', ')').toString())
}

private fun areBracketsFine(code: String, openBracket: Char, closeBracket: Char): Boolean {
    var counter = 0
    code.forEach { char ->
        if (char == openBracket) counter++
        else if (char == closeBracket) counter--
        if (counter < 0) return false
    }
    return counter == 0
}
