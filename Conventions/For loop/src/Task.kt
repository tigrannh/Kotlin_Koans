class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate>{
            var temp = start

            override fun hasNext(): Boolean {
                return temp <= end
            }

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val cur = temp
                temp = temp.followingDate()
                return cur
            }

        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}