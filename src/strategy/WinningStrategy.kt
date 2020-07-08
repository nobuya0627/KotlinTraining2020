package strategy

import java.util.*

class WinningStrategy(seed: Int) : Strategy {
    private val random: Random
    private var won = false
    lateinit private var prevHand: Hand
    override fun nextHand(): Hand {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3))
        }
        return prevHand
    }

    override fun study(win: Boolean) {
        won = win
    }

    init {
        random = Random(seed.toLong())
    }
}