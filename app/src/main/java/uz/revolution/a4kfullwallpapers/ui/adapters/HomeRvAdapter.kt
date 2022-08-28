package uz.revolution.a4kfullwallpapers.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_item_rv_image.view.*
import uz.revolution.a4kfullwallpapers.R

class HomeRvAdapter(var listImages: ArrayList<String>) : RecyclerView.Adapter<HomeRvAdapter.VH>() {


    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(string: String, position: Int) {
            itemView.progress.visibility = View.VISIBLE
            Picasso.get().load(string).into(itemView.image_view_home, object : Callback {
                override fun onSuccess() {
                    itemView.progress.visibility = View.INVISIBLE
                }

                override fun onError(e: Exception?) {}
            })

            itemView.setOnClickListener {
                if (onImageClick != null) {
                    onImageClick!!.onClick(string)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_rv_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listImages[position], position)
    }

    override fun getItemCount(): Int = listImages.size

    private var onImageClick: OnImageClick? = null

    interface OnImageClick {
        fun onClick(string: String)
    }

    fun setOnImageClick(onImageClick: OnImageClick) {
        this.onImageClick = onImageClick
    }
}