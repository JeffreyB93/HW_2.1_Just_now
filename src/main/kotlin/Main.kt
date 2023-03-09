fun main() {
    val howLongAgo  = 52200
    val time = agoToText(howLongAgo)
    val str = endOfPhrase(time, howLongAgo)
    println(str)
}

fun agoToText(howLongAgo: Int): String {
    val time = when {
        (howLongAgo in 0..60) -> "только что"
        (howLongAgo in 61..60 * 60) -> "минут назад"
        (howLongAgo in 60 * 60 + 1..24 * 60 * 60) -> "часов назад"
        (howLongAgo in 24 * 60 * 60 + 1..2 * 24 * 60 * 60) -> "вчера"
        (howLongAgo in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60) -> "позавчера"
        (3 * 24 * 60 * 60 + 1 <= howLongAgo ) -> "давно"
        else -> ""
    }
    return time
}

fun endOfPhrase(time: String, howLongAgo: Int): String{
    val str = when (time) {
        "минут назад" -> minutes(howLongAgo)
        "часов назад" -> hours(howLongAgo)
        else -> time
    }
    return str
}

fun minutes(howLongAgo: Int): String {

    val howLongAgoDouble = howLongAgo / 60
    val howLongAgoDoubleStr = howLongAgoDouble.toString()

    if (howLongAgoDoubleStr[howLongAgoDoubleStr.length - 1] == '1' && howLongAgo != 11) {
        return "$howLongAgoDoubleStr минуту назад"
    }
    else if (howLongAgoDouble in 2..4) {
        return "$howLongAgoDoubleStr минуты назад"
    }
    else {
        return "$howLongAgoDoubleStr минут назад"
    }
}

fun hours(howLongAgo: Int): String {

    val howLongAgoDouble = howLongAgo / (60 * 60)
    val howLongAgoDoubleStr = howLongAgoDouble.toString()


    if (howLongAgoDoubleStr[howLongAgoDoubleStr.length - 1] == '1' && howLongAgo != 11) {
        return "$howLongAgoDoubleStr чам назад"
    }
    else if (howLongAgoDouble in 2..4) {
        return "$howLongAgoDoubleStr часа назад"
    }
    else {
        return "$howLongAgoDoubleStr часов назад"
    }
}