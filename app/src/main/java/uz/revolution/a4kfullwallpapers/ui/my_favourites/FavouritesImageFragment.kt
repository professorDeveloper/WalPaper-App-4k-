package uz.revolution.a4kfullwallpapers.ui.my_favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso
import io.alterac.blurkit.BlurLayout
import kotlinx.android.synthetic.main.fragment_home_image.view.*
import uz.revolution.a4kfullwallpapers.R


private const val ARG_PARAM1 = "image"

class FavouritesImageFragment : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    lateinit var root: View
    var blurLayout: BlurLayout? = null
    var a = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_favourites_image, container, false)
        blurLayout = root.findViewById(R.id.blur_layout)

        Picasso.get().load(param1).error(R.drawable.aaaaa).into(root.home_image_view)

        root.home_image_share_btn.setOnClickListener {
            Toast.makeText(root.context, "Share", Toast.LENGTH_SHORT).show()
        }
        root.home_image_share_btn1.setOnClickListener {
            Toast.makeText(root.context, "Share", Toast.LENGTH_SHORT).show()
        }

        root.home_image_info_btn.setOnClickListener {
            val dialog = BottomSheetDialog(root.context, R.style.SheetDialog)
            val view = layoutInflater.inflate(R.layout.item_bottom_sheet_info_dialog, null, false)
            dialog.setContentView(view)
            view.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        root.home_image_info_btn1.setOnClickListener {
            val dialog = BottomSheetDialog(root.context, R.style.SheetDialog)
            val view = layoutInflater.inflate(R.layout.item_bottom_sheet_info_dialog, null, false)
            dialog.setContentView(view)
            view.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        root.home_image_download_btn.setOnClickListener {
            Toast.makeText(root.context, "Download", Toast.LENGTH_SHORT).show()
        }

        root.home_image_download_btn1.setOnClickListener {
            Toast.makeText(root.context, "Download", Toast.LENGTH_SHORT).show()
        }

        root.home_image_edit_btn.setOnClickListener {
            Toast.makeText(root.context, "Edit", Toast.LENGTH_SHORT).show()
        }

        root.home_image_edit_btn1.setOnClickListener {
            Toast.makeText(root.context, "Edit", Toast.LENGTH_SHORT).show()
        }

        root.home_image_like_btn.setOnClickListener {

            if (a) {
                root.home_image_like_btn1.setImageResource(R.drawable.ic_heart_liked)
                a = false
                Toast.makeText(root.context, "Liked!", Toast.LENGTH_SHORT).show()
            } else {
                root.home_image_like_btn1.setImageResource(R.drawable.ic_heart_btn)
                a = true
                Toast.makeText(root.context, "Unliked!", Toast.LENGTH_SHORT).show()
            }
        }

        root.home_image_like_btn1.setOnClickListener {

            if (a) {
                root.home_image_like_btn1.setImageResource(R.drawable.ic_heart_liked)
                a = false
                Toast.makeText(root.context, "Liked!", Toast.LENGTH_SHORT).show()
            } else {
                root.home_image_like_btn1.setImageResource(R.drawable.ic_heart_btn)
                a = true
                Toast.makeText(root.context, "Unliked!", Toast.LENGTH_SHORT).show()
            }
        }

        root.back_to_home_fragment.setOnClickListener {
            findNavController().popBackStack()
        }
        root.back_to_home_fragment1.setOnClickListener {
            findNavController().popBackStack()
        }

        root.home_image_share_with_btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("image2", param1)
            findNavController().navigate(R.id.homeImageFragment2, bundle)
        }

        root.home_image_share_with_btn1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("image2", param1)
            findNavController().navigate(R.id.homeImageFragment2, bundle)
        }

        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            FavouritesImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}