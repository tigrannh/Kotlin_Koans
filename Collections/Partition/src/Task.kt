// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
        customers.filter {
            val (first, second ) = it.orders.partition { it.isDelivered }
            second.size > first.size
        }.toSet()
