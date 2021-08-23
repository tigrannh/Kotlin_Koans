// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val products = customers.flatMap { it.getOrderedProducts() }.toMutableSet()
    return customers.fold(products) { prod, cust ->
            val customerProd = cust.getOrderedProducts()
            for (i in prod) {
                if (!customerProd.contains(i)) prod.remove(i)
            }
            prod

    }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }