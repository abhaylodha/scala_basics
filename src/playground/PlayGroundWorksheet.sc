
val a = Seq(1, 2, 3, 4, 5 ,6)

val b = a.filter(x => x%2 == 0)

def isEven(a : Int) : Boolean =   a%2 == 0

val c = a.filter(x => isEven(x))

def multiplyBy5 (a : Int) : Int = a * 5

val d = a.map(x => multiplyBy5(x))

val e = a.map(multiplyBy5(_))

val f = a.map(multiplyBy5)
