package iglo.indocyber.penjualan.activity.product

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import iglo.indocyber.common.entity.Product
import iglo.indocyber.penjualan.databinding.LayoutProductListItemBinding

class ProductListAdapter(
    val context: Context
) : RecyclerView.Adapter<ProductListViewHolder>() {
    val dataDiffer = AsyncListDiffer<Product>(this, differProduct)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            LayoutProductListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        var data = dataDiffer.currentList[position]
        holder.binding.data = data
        holder.binding.cardView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("EXTRA_DATA_PRODUCT_CODE", data.productCode)
            context.startActivity(intent)
        }
        holder.binding.buy.setOnClickListener {
            holder.binding.cancel.visibility = View.VISIBLE
            holder.binding.buy.visibility = View.GONE
//            data.isSelected.equals(true)
        }

        holder.binding.cancel.setOnClickListener {
            holder.binding.buy.visibility = View.VISIBLE
            holder.binding.cancel.visibility = View.GONE
//            data.isSelected.equals(false)
        }


    }

    override fun getItemCount(): Int {
        return dataDiffer.currentList.size
    }

    fun submitData(list: List<Product>) {
        dataDiffer.submitList(list)
    }

    companion object {
        val differProduct = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productCode == newItem.productCode
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return true
            }

        }
    }

}

class ProductListViewHolder(
    val binding: LayoutProductListItemBinding
) : RecyclerView.ViewHolder(binding.root)