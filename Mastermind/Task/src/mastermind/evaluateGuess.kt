package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
var rightPosition: Int =0
var wrongPosition: Int = 0
var tempString: String = guess
for(i in secret.indices) {
    val correctIndex: Int
    if(secret[i] == tempString[i]){
        correctIndex = i
    }
    else{
        correctIndex = tempString.indexOf(secret[i])

    }
    if( correctIndex != -1) {
        if (i == correctIndex || secret[correctIndex] == tempString[correctIndex] ) {
            ++rightPosition
        } else {
            ++wrongPosition
        }
        tempString = tempString.substring(0, correctIndex) + "X" + tempString.substring(1 + correctIndex)
    }
}
    return Evaluation(rightPosition, wrongPosition)
}
