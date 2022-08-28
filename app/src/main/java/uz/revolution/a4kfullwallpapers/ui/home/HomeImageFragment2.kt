package uz.revolution.a4kfullwallpapers.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home_image2.view.*
import uz.revolution.a4kfullwallpapers.R
import java.lang.Exception

private const val ARG_PARAM1 = "image2"

class HomeImageFragment2 : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_home_image2, container, false)

        root.progress.visibility=View.VISIBLE
        Picasso.get().load(param1).into(root.home_image_view2,object :Callback{
            override fun onSuccess() {
                root.progress.visibility=View.INVISIBLE
            }

            override fun onError(e: Exception?) {

            }

        })

        root.back_to_home_fragment.setOnClickListener {
            findNavController().popBackStack()
        }

        root.back_to_home_fragment1.setOnClickListener {
            findNavController().popBackStack()
        }

        root.share_with_home_btn.setOnClickListener {
            findNavController().popBackStack(R.id.nav_home,false)
        }

        root.share_with_home_btn1.setOnClickListener {
            findNavController().popBackStack(R.id.nav_home,false)
        }

        root.share_with_lock_1.setOnClickListener {
            Toast.makeText(root.context, "Button!", Toast.LENGTH_SHORT).show()
        }

        root.share_with_lock_11.setOnClickListener {
            Toast.makeText(root.context, "Button!", Toast.LENGTH_SHORT).show()
        }

        root.share_with_lock_2.setOnClickListener {
            Toast.makeText(root.context, "Button!", Toast.LENGTH_SHORT).show()
        }

        root.share_with_lock_21.setOnClickListener {
            Toast.makeText(root.context, "Button!", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeImageFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}