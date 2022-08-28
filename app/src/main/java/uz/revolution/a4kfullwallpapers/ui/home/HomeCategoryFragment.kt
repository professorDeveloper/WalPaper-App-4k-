package uz.revolution.a4kfullwallpapers.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_fragment_category.view.*
import uz.revolution.a4kfullwallpapers.R
import uz.revolution.a4kfullwallpapers.ui.adapters.HomeRvAdapter


private const val ARG_PARAM1 = "param1"

class CategoryFragment : Fragment() {

    private var param1: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getStringArrayList(ARG_PARAM1)
        }
    }

    lateinit var root: View
    lateinit var adapter: HomeRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.home_fragment_category, container, false)

        adapter = HomeRvAdapter(param1!!)
        root.rv_home.adapter = adapter

        adapter.setOnImageClick(object : HomeRvAdapter.OnImageClick {
            override fun onClick(string: String) {
                val bundle = Bundle()
                bundle.putString("image", string)
                findNavController().navigate(
                    R.id.homeImageFragment,
                    bundle
                )
            }

        })

        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: ArrayList<String>) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_PARAM1, param1)
                }
            }
    }
}