package iglo.indocyber.penjualan.activity.product

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.databinding.LayoutCheckoutPageBinding
import iglo.indocyber.penjualan.databinding.LayoutProductDetailBinding
import iglo.indocyber.penjualan.view_model.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckoutProductActivity : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_checkout_page
    lateinit var binding : LayoutCheckoutPageBinding


    val vm: ProductViewModel by viewModel()
    val adapter = CheckoutProductAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        binding.recycler.adapter = adapter

        vm.productList.observe(this@CheckoutProductActivity){
            adapter.submitData(it.toList())
        }

    }
}