import java.util.HashMap

fun <T, V> buildMap(build: HashMap<T, V>.() -> Unit) : Map<T, V> {
    val hashMap =  HashMap<T, V>()
    hashMap.build()
    return hashMap
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
