import kotlin.random.Random

class Card(val rank: Rank, val suit: Suit) {
    enum class Rank(val value: Int) {
        ACE(11),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10)
    }

    enum class Suit {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES
    }

    override fun toString(): String {
        return "$rank of $suit"
    }
}

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        for (suit in Card.Suit.values()) {
            for (rank in Card.Rank.values()) {
                cards.add(Card(rank, suit))
            }
        }
        shuffle()
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun draw(): Card {
        return cards.removeAt(0)
    }

    fun size(): Int {
        return cards.size
    }
}

class Hand {
    private val cards = mutableListOf<Card>()

    fun addCard(card: Card) {
        cards.add(card)
    }

    fun getCards(): List<Card> {
        return cards
    }

    fun calculateValue(): Int {
        var value = 0
        var hasAce = false
        for (card in cards) {
            value += card.rank.value
            if (card.rank == Card.Rank.ACE) {
                hasAce = true
            }
        }
        if (hasAce && value > 21) {
            value -= 10 // Treat Ace as 1 if it busts the hand
        }
        return value
    }

    fun isBust(): Boolean {
        return calculateValue() > 21
    }

    fun isBlackjack(): Boolean {
        return calculateValue() == 21 && cards.size == 2
    }
}

class Game {
    private val deck = Deck()
    private val playerHand = Hand()
    private val dealerHand = Hand()

    fun play() {
        // Deal initial cards
        playerHand.addCard(deck.draw())
        playerHand.addCard(deck.draw())
        dealerHand.addCard(deck.draw())
        dealerHand.addCard(deck.draw())

        // Player's turn
        println("Your hand: ${playerHand.getCards()}")
        println("Your value: ${playerHand.calculateValue()}")
        while (!playerHand.isBust()) {
            println("Hit or Stand? (h/s)")
            val input = readLine()
            if (input == "h") {
                playerHand.addCard(deck.draw())
                println("Your hand: ${playerHand.getCards()}")
                println("Your value: ${playerHand.calculateValue()}")
            } else {
                break
            }
        }

        // Dealer's turn
        if (!playerHand.isBust()) {
            println("Dealer's hand: ${dealerHand.getCards()}")
            println("Dealer's value: ${dealerHand.calculateValue()}")
            while (dealerHand.calculateValue() < 17) {
                dealerHand.addCard(deck.draw())
                println("Dealer's hand: ${dealerHand.getCards()}")
                println("Dealer's value: ${dealerHand.calculateValue()}")
            }
        }

        // Determine winner
        if (playerHand.isBust()) {
            println("You bust! Dealer wins.")
        } else if (dealerHand.isBust()) {
            println("Dealer busts! You win.")
        } else {
            val playerValue = playerHand.calculateValue()
            val dealerValue = dealerHand.calculateValue()
            if (playerValue > dealerValue) {
                println("You win with $playerValue!")
            } else if (playerValue < dealerValue) {
                println("Dealer wins with $dealerValue!")
            } else {
                println("It's a tie!")
            }
        }
    }
}

fun main() {
    val game = Game()
    game.play()
}