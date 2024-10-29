import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите первое число:")
    val num1 = scanner.nextDouble()

    println("Введите операцию (+, -, , /):")
    val operator = scanner.next()

    println("Введите второе число:")
    val num2 = scanner.nextDouble()

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "" -> num1 * num2
                "/" -> {
            if (num2 == 0.0) {
                println("Деление на ноль!")
                return
            }
            num1 / num2
        }
        else -> {
            println("Некорректная операция!")
            return
        }
    }

    println("$num1 $operator $num2 = $result")
}