fun isPalindrome(word: String): Boolean {
    val cleanWord = word.toLowerCase().replace("\\s+".toRegex(), "")
    return cleanWord == cleanWord.reversed()
}

fun main() {
    println("Введите слово:")
    val word = readLine()!!

    if (isPalindrome(word)) {
        println("Слово '$word' является палиндромом.")
    } else {
        println("Слово '$word' не является палиндромом.")
    }
}