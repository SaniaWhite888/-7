fun calculatePoints(wins: Int, draws: Int, losses: Int): Int {
    return wins  3 + draws  1 + losses  0
}
fun findSmallest(numbers: List<Int>): Int {
    return numbers.minOrNull() ?: throw IllegalArgumentException("Список пуст")
}
fun areEqual(num1: Int, num2: Int): Boolean {
    return num1 == num2
}
fun main() {
    // Подсчет очков
    val wins = 5
    val draws = 2
    val losses = 3
    val points = calculatePoints(wins, draws, losses)
    println("Количество очков: $points")

    // Поиск минимального числа
    val numbers = listOf(10, 5, 15, 2, 8)
    val smallestNumber = findSmallest(numbers)
    println("Самое маленькое число: $smallestNumber")

    // Сравнение чисел
    val num1 = 7
    val num2 = 7
    val areNumbersEqual = areEqual(num1, num2)
    println("Числа равны: $areNumbersEqual")
}