package strategy

enum class Hand(val value : Int){
    HANDVALUE_GUU(0),
    HANDVALUE_CHO(1),
    HANDVALUE_PAA(2);

    fun fight(h: Hand): Int {
        return if (this === h) {
            0
        } else if ((value + 1) % 3 == h.value) {
            1
        } else {
            -1
        }
    }

    fun isStrongerThan(h: Hand): Boolean {
        return fight(h) == 1
    }

    fun isWeakerThan(h: Hand): Boolean {
        return fight(h) == -1
    }

    companion object{
        fun getHand(handvalue: Int): Hand {
            return values().firstOrNull{it.value == handvalue} ?: HANDVALUE_GUU
        }
    }
}