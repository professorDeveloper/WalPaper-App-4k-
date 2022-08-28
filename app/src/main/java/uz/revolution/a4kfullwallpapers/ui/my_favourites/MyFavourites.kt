package uz.revolution.a4kfullwallpapers.ui.my_favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_my_favourites.view.*
import kotlinx.android.synthetic.main.fragment_slideshow.view.*
import uz.revolution.a4kfullwallpapers.R
import uz.revolution.a4kfullwallpapers.ui.adapters.HomeRvAdapter

private const val ARG_PARAM1 = "param1"

class MyFavourites : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "My favourites"
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
    ): View? {
        root = inflater.inflate(R.layout.fragment_my_favourites, container, false)

        loadData()
        adapter = HomeRvAdapter(data)
        root.rv_favourites.adapter = adapter

        adapter.setOnImageClick(object : HomeRvAdapter.OnImageClick {
            override fun onClick(string: String) {
                val bundle = Bundle()
                bundle.putString("image", string)
                findNavController().navigate(R.id.favouritesImageFragment, bundle)
            }

        })

        val menu = root.favourites_bottom_navigation_view.menu

        for (i in 0 until menu.size()) {
            if (menu.getItem(i).itemId == R.id.like_bottom) {
                menu.getItem(i).isChecked = true
            }
        }

        root.favourites_bottom_navigation_view.setOnNavigationItemSelectedListener { item ->

            val itemID = item.itemId

            when (itemID) {
                R.id.home_bottom -> {
                    findNavController().navigate(R.id.nav_home)
                    item.isChecked = true
                }
                R.id.popular_bottom -> {
                    findNavController().navigate(R.id.nav_popular)
                    item.isChecked = true
                }
                R.id.random_bottom -> {
                    findNavController().navigate(R.id.nav_random)
                    item.isChecked = true
                }
                R.id.like_bottom -> {
                    item.isChecked = true
                }
            }

            true
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "My favourites"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)

    }

    private fun loadData() {
        data = ArrayList()
        for (i in 100..300) {
            data.add("https://picsum.photos/id/$i/400/700")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            MyFavourites().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}