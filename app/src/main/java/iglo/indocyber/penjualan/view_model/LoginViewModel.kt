package iglo.indocyber.penjualan.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import iglo.indocyber.common.entity.Login
import iglo.indocyber.common.entity.Product
import iglo.indocyber.service.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application,
    val loginUseCase: LoginUseCase) : AndroidViewModel(application)  {

    val loginInfo = MutableLiveData<Boolean>()
    var username = "wew"
    var password = "wew"


    fun login(){
        viewModelScope.launch {
            loginUseCase.invoke().collect{
                for (login: Login in it){
                    if(login.user.equals(username).and(login.password.equals(password))) {
                        loginInfo.postValue(true)
                    }else{
                        loginInfo.postValue(false)
                    }

                }
            }
        }

    }
}