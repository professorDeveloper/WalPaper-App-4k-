package uz.revolution.a4kfullwallpapers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_history.view.*
import kotlinx.android.synthetic.main.fragment_my_favourites.view.*
import uz.revolution.a4kfullwallpapers.R
import uz.revolution.a4kfullwallpapers.ui.adapters.HomeRvAdapter

private const val ARG_PARAM1 = "param1"

class HistoryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "History"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)
    }
    lateinit var root: View
    lateinit var adapter: HomeRvAdapter
    lateinit var data: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_history, container, false)

        loadData()
        adapter = HomeRvAdapter(data)
        root.rv_history.adapter = adapter

        adapter.setOnImageClick(object : HomeRvAdapter.OnImageClick {
            override fun onClick(string: String) {
                val bundle = Bundle()
                bundle.putString("image", string)
                findNavController().navigate(R.id.homeImageFragment, bundle)
            }
        })

        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "History"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)

    }

    private fun loadData() {
        data = ArrayList()
        for (i in 200..250) {
            data.add("https://picsum.photos/id/$i/400/700")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}