

fun main(args: Array<String>) {
    
    println("Enter 3 numbers, 1:start 2:end 3:inc")
    var (a, b,c) = readLine()!!.split(' ')

    println("test")
    val generator : NumberGenerator = IncrementalNumberGenerator(a.toInt(), b.toInt(), c.toInt())
    val observer1 : Observer = DigitObserver()
    val observer2 : Observer = GraphObserver()
    generator.addObserver(observer1)
    generator.addObserver(observer2)
    generator.execute()
}

interface Observer {
    fun update( gen : NumberGenerator )
}


class DigitObserver : Observer {
    override fun update( gen : NumberGenerator ){
        println("DigitObserver:" + gen.getNumber());
        try {
            Thread.sleep(100);
        } catch (e : Exception) {
        
        }
    }

}

class  FrameObserver : Observer {
    override fun update( gen : NumberGenerator ){
        println("Running!")
    }

}

class GraphObserver : Observer {
    override fun update( gen : NumberGenerator ){
       val buf = StringBuilder()
       for ( i in 0..gen.getNumber() ) {
           buf.append("*")
        }
        println(buf.toString());
    }

}

class IncrementalNumberGenerator( start:Int, end:Int, inc:Int ) : NumberGenerator() {
    var mNumber = start
    val mEnd = end
    val mInc = inc

    override fun getNumber() : Int{
        return mNumber
    }
    override fun execute(){
        while (mNumber <= mEnd) {
            notifyObservers();
            mNumber += mInc;
        }
    }
}

abstract class NumberGenerator {
    val observers : MutableList<Observer> = mutableListOf()
    fun addObserver( obs : Observer ){
        observers.add(obs)
    }
    fun deleteObserver( obs : Observer ) {
        observers.remove(obs)
    }
    fun notifyObservers() {
        for ( obs in observers ) {
            obs.update(this)
        }
    }
    abstract fun getNumber() : Int 
    abstract fun execute()
}