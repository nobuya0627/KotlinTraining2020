package strategy

class Player(private val name: String, private val strategy: Strategy) {
    private var wincount = 0
    private var losecount = 0
    private var gamecount = 0
    fun nextHand(): Hand {
        return strategy.nextHand()
    }

    fun win() {
        strategy.study(true)
        wincount++
        gamecount++
    }

    fun lose() {
        strategy.study(false)
        losecount++
        gamecount++
    }

    fun even() {
        gamecount++
    }

    override fun toString(): String {
        return "[$name:$gamecount games, $wincount win, $losecount lose]"
    }

}