package iglo.indocyber.penjualan.activity.product

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.databinding.LayoutProductListBinding
import iglo.indocyber.penjualan.view_model.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListActivity : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_product_list
    lateinit var binding : LayoutProductListBinding

    val vm: ProductViewModel by viewModel()
    val adapter = ProductListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        binding.recycler.adapter = adapter

        vm.productList.observe(this@ProductListActivity){
            adapter.submitData(it.toList())
        }

        binding.Checkout.setOnClickListener {
            val intent = Intent(this, CheckoutProductActivity::class.java)
            this.startActivity(intent)
        }
    }

}