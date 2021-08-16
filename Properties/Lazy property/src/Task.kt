class LazyProperty(val initializer: () -> Int) {
    var first: Int? = null
    val lazy: Int
        get() {
            if (first == null){
                first = initializer()
            }
            return first!!
        }
}
