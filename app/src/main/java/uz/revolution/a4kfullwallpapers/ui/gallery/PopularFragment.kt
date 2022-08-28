package uz.revolution.a4kfullwallpapers.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.view.tab_layout
import kotlinx.android.synthetic.main.fragment_home.view.view_pager
import kotlinx.android.synthetic.main.fragment_popular.view.*
import kotlinx.android.synthetic.main.tab_item.view.*
import uz.revolution.a4kfullwallpapers.R
import uz.revolution.a4kfullwallpapers.ui.adapters.HomeCategoryAdapter
import uz.revolution.a4kfullwallpapers.ui.models.Category

class PopularFragment : Fragment() {

    lateinit var root: View
    private var data: ArrayList<Category>? = null
    lateinit var homeCategoryAdapter: HomeCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_popular, container, false)

        val menu = root.popular_bottom_navigation_view.menu
        for (i in 0 until menu.size) {
            val item = menu.getItem(i)
            if (item.itemId == R.id.popular_bottom) {
                item.isChecked = true
            }
        }

        root.popular_bottom_navigation_view.setOnNavigationItemSelectedListener { item ->

            val itemID = item.itemId

            when (itemID) {
                R.id.home_bottom -> {
                    findNavController().navigate(R.id.nav_home)
                }
                R.id.popular_bottom -> {
                    item.isChecked = true
                }
                R.id.random_bottom -> {
                    findNavController().navigate(R.id.nav_random)
                }
                R.id.like_bottom -> {
                    findNavController().navigate(R.id.nav_liked)
                }
            }

            true
        }

        loadData()
        homeCategoryAdapter = HomeCategoryAdapter(data!!, childFragmentManager)
        root.view_pager.adapter = homeCategoryAdapter
        root.tab_layout.setupWithViewPager(root.view_pager)

        setTabs()

        root.tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.circle_layout?.visibility = View.VISIBLE
                customView?.title_tv?.setTextColor(resources.getColor(R.color.white))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.circle_layout?.visibility = View.INVISIBLE
                customView?.title_tv?.setTextColor(resources.getColor(R.color.white50))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })



        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Popular"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Popular"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_navigate_btn)
    }

    private fun setTabs() {
        val tabCount = root.tab_layout.tabCount

        for (i in 0 until tabCount) {
            val tabView = LayoutInflater.from(root.context).inflate(R.layout.tab_item, null, false)
            val tab = root.tab_layout.getTabAt(i)
            tab?.customView = tabView
            tabView.title_tv.text = data!![i].title

            if (i == 0) {
                tabView.circle_layout.visibility = View.VISIBLE
                tabView?.title_tv?.setTextColor(resources.getColor(R.color.white))
            } else {
                tabView.circle_layout.visibility = View.INVISIBLE
                tabView?.title_tv?.setTextColor(resources.getColor(R.color.white50))
            }
        }
    }

    private fun loadData() {
        data = ArrayList()
        val allList = ArrayList<String>()
        val newList = ArrayList<String>()
        val animalList = ArrayList<String>()
        val technologyList = ArrayList<String>()
        val natureList = ArrayList<String>()
        val sportList = ArrayList<String>()
        for (i in 300..899) {
            allList.add("https://picsum.photos/id/$i/400/700")
            if (i in 400..499) {
                newList.add("https://picsum.photos/id/$i/400/700")
            }
            if (i in 500..599) {
                animalList.add("https://picsum.photos/id/$i/400/700")
            }
            if (i in 600..699) {
                technologyList.add("https://picsum.photos/id/$i/400/700")
            }
            if (i in 700..799) {
                natureList.add("https://picsum.photos/id/$i/400/700")
            }
            if (i in 800..899) {
                sportList.add("https://picsum.photos/id/$i/400/700")
            }
        }

        data!!.add(Category("All", allList))
        data!!.add(Category("New", newList))
        data!!.add(Category("Animals", animalList))
        data!!.add(Category("Technology", technologyList))
        data!!.add(Category("Nature", natureList))
        data!!.add(Category("Sport", sportList))
    }
}