package iglo.indocyber.service.usecase

import iglo.indocyber.common.entity.Product
import kotlinx.coroutines.flow.flow

class ProductUseCase {
    operator fun invoke() = flow{
        val product = arrayListOf<Product>(
            Product("SKHPPA", "So Klin Pewangi", 15000.00,"IDR",
                10, "13cm x 10cm", "PCS", false ),
            Product("AEDS", "Giv Biru", 11000.00,"IDR",
                0, "5cm x 2cm", "PCS" , false),
            Product("LOLST", "So Klin Liquid", 18000.00,"IDR",
                0, "13cm x 10cm", "PCS" ,false),
            Product("TOTWEW", "Giv Kuning", 10000.00,"IDR",
                0, "5cm x 2cm", "PCS" , false )
        )

        emit(product)
    }
}