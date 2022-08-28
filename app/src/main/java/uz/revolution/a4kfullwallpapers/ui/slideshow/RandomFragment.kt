package uz.revolution.a4kfullwallpapers.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_slideshow.view.*
import uz.revolution.a4kfullwallpapers.R
import uz.revolution.a4kfullwallpapers.ui.adapters.HomeRvAdapter

class RandomFragment : Fragment() {

    lateinit var root: View
    lateinit var adapter:HomeRvAdapter
    lateinit var data:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        loadData()
        adapter= HomeRvAdapter(data)
        root.rv_random.adapter=adapter

        val menu=root.random_bottom_navigation_view.menu

        for (i in 0 until menu.size()) {
            if (menu.getItem(i).itemId == R.id.random_bottom) {
                menu.getItem(i).isChecked = true
            }
        }

        adapter.setOnImageClick(object :HomeRvAdapter.OnImageClick{
            override fun onClick(string: String) {
                val bundle = Bundle()
                bundle.putString("image",string)
                findNavController().navigate(R.id.homeImageFragment,bundle)
            }

        })

        root.random_bottom_navigation_view.setOnNavigationItemSelectedListener { item ->

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
                    findNavController().navigate(R.id.nav_liked)
                    item.isChecked = true
                }
            }

            true
        }

        return root
    }

    private fun loadData() {
        data = ArrayList()
        for (i in 1..300) {
            data.add("https://picsum.photos/id/$i/400/700")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title="Random"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title="Random"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)
    }
}