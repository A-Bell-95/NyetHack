import kotlin.random.Random
import kotlin.system.exitProcess

fun main(args: Array<String>) {
   val clientMoney = slotAnnotation()
   val stake = stakeChoise()
   startGame(clientMoney,stake)
}
fun slotAnnotation(): Int? {
     println("Hello, welcome to NaebalovoSLot! Please insert your last money:")
     val clientMoney = readLine()?.toInt()
     println("Your bankroll is $clientMoney$")
    return clientMoney
}
fun stakeChoise(): Int {
     val stakes = listOf(5,10,25,50)
     println("Choose your stake $stakes, right a number from 1 to 4")
     val s = readLine()?.toInt()
     var stake = 0
    when (s) {
        1 -> stake = stakes[0]
        2 -> stake = stakes[1]
        3 -> stake = stakes[2]
        4 -> stake = stakes[3]
    }
    println("Your stake is $stake$")
    return stake
}
fun startGame(valet:Int?, stake:Int) {
    println("To start game write 's' on board, for exit write 'e'")
    val command = readLine()
    when (command) {
        "s" -> println("Your game was started!")
        "e" -> println("Goodbye!")
    }
    if (command == "e")
        exitProcess(0)
    var remainingMoney = valet?.minus(stake)
    println("Your remaining money is $remainingMoney")
    println("Vroom,vrooom,vroom")
    val number = Random.nextInt(10,99)
    println(number)
    when(number){
        11,22,33,44,55,66,88,99 -> {
            println("Congrats, your win ${stake * 4}$")
            if (remainingMoney != null) {
                remainingMoney += stake * 4
            }
        }
        77 -> {
            println("JACKPOT, your win ${stake*10}")
            if (remainingMoney != null) {
                remainingMoney += stake * 10
            }
        }
        else -> println("No price, TRY AGAIN")
    }
    println("remaining money is $remainingMoney")
    if (remainingMoney != null)
        startGame(remainingMoney,stake)
}