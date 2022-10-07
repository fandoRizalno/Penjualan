package iglo.indocyber.penjualan.module

import iglo.indocyber.penjualan.view_model.LoginViewModel
import iglo.indocyber.penjualan.view_model.ProductViewModel
import iglo.indocyber.service.usecase.LoginUseCase
import iglo.indocyber.service.usecase.ProductUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel {
        LoginViewModel(get(),get())
    }
    viewModel {
        ProductViewModel(get(),get())
    }

}

val useCaseModule = module {
    factory {
        ProductUseCase()
    }
    factory {
        LoginUseCase()
    }

}