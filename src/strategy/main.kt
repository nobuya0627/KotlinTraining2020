package strategy

import kotlin.random.Random

fun main(args: Array<String>) {
    val player1 = Player("Taro", WinningStrategy(Random.nextInt(10)))
    val player2 = Player("Hana", ProbStrategy(Random.nextInt(10)))
    repeat(10000){
        val nextHand1 = player1.nextHand()
        val nextHand2 = player2.nextHand()
        when {
            nextHand1.isStrongerThan(nextHand2) -> {
                println("Winner:$player1")
                player1.win()
                player2.lose()
            }
            nextHand2.isStrongerThan(nextHand1) -> {
                println("Winner:$player2")
                player1.lose()
                player2.win()
            }
            else -> {
                println("Even...")
                player1.even()
                player2.even()
            }
        }
    }

    println("Total result:")
    System.out.println(player1.toString())
    System.out.println(player2.toString())
}