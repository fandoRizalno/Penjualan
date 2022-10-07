package iglo.indocyber.penjualan.activity.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.activity.product.ProductListActivity
import iglo.indocyber.penjualan.databinding.LayoutLoginBinding
import iglo.indocyber.penjualan.view_model.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity() : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_login
    lateinit var binding : LayoutLoginBinding
    val vm:LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)
//
//        binding.username.addTextChangedListener {
//            vm.username = it.toString()
//        }
//        binding.password.addTextChangedListener {
//            vm.password = it.toString()
//        }
//
//        binding.loginButton.setOnClickListener {
//            vm.login()
//            vm.loginInfo.observe(this@LoginActivity){
//                if(vm.loginInfo.equals(true)){
//                    val intent = Intent(this, ProductListActivity::class.java)
//                    this.startActivity(intent)
//                }else{
//                }
//            }
//        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            this.startActivity(intent)
        }
    }
}