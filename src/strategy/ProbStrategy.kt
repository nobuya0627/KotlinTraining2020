package strategy

import java.util.*

class ProbStrategy(seed: Int) : Strategy {
    private val random: Random
    private var prevHandValue = 0
    private var currentHandValue = 0
    private val history = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
    override fun nextHand(): Hand {
        val bet = random.nextInt(getSum(currentHandValue))
        var handvalue = 0
        handvalue = if (bet < history[currentHandValue][0]) {
            0
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            1
        } else {
            2
        }
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return Hand.getHand(handvalue)
    }

    private fun getSum(hv: Int): Int {
        var sum = 0
        for (i in 0..2) {
            sum += history[hv][i]
        }
        return sum
    }

    override fun study(win: Boolean) {
        if (win) {
            history[prevHandValue][currentHandValue]++
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }

    init {
        random = Random(seed.toLong())
    }
}