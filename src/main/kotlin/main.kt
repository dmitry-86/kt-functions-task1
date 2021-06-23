fun main() {
    val seconds = 2500
    val result = agoToText(seconds);
    println("был(а) в сети $result");
}

fun agoToText(seconds: Int): String {
    val minutes = seconds/60
    val hours = seconds/3600

    return when (seconds) {
        in 0..60 -> "только что" //от 0 до 60
        in 61..60*60 ->  "$minutes ${minutesConverter(seconds)} назад" //от 61 до 60 * 60
        in (60*60+1)..24*60*60 ->  "$hours ${hoursConverter(seconds)} назад" //от 60 * 60 + 1 до 24 * 60 * 60 (сутки)
        in (24*60*60+1)..24*60*60*2 -> "сегодня" //от суток до двух
        in (24*60*60*2+1)..24*60*60*3 -> "вчера" //от двух суток до трёх
        else -> "давно" //больше трёх суток
    }
}

fun hoursConverter(seconds: Int) : String = when {
        (seconds/3600)%100 in 11..14 -> "часов"
        (seconds/3600)%10 == 1 -> "час"
        (seconds/3600)%10 in 2..4 -> "часа"
        else -> "часов"
    }

fun minutesConverter(seconds: Int): String = when {
        (seconds/60)%100 in 11..14 -> "минут"
        (seconds/60)%10 == 1 -> "минуту"
        (seconds/60)%10 in 2..4 -> "минуты"
        else -> "минут"
    }