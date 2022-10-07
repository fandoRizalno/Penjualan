package iglo.indocyber.service.usecase

import iglo.indocyber.common.entity.Login
import iglo.indocyber.common.entity.Product
import kotlinx.coroutines.flow.flow

class LoginUseCase {
    operator fun invoke() = flow{
        val login = arrayListOf<Login>(
            Login("fand","fand" ),
            Login("wew","wew")
        )

        emit(login)
    }
}