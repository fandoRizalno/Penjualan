package iglo.indocyber.penjualan.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import iglo.indocyber.common.entity.Product
import iglo.indocyber.service.usecase.ProductUseCase
import kotlinx.coroutines.launch

class ProductViewModel (
    application: Application,
    val productUseCase: ProductUseCase) : AndroidViewModel(application)  {

    val productList = MutableLiveData<ArrayList<Product>>()
    val productOne = MutableLiveData<Product>()
    val productCode = MutableLiveData<String>()

    init {
        getProductList()
    }

    fun getProductList(){
        viewModelScope.launch {
            productUseCase.invoke().collect{
                productList.postValue(it)
            }
        }
    }

    fun getOnePoduct(id : String){
        viewModelScope.launch {
            productUseCase.invoke().collect{
                for (product:Product in it){
                    if(product.productCode.equals(id)){
                        productOne.postValue(product)
                    }
                }
            }
        }

    }


}