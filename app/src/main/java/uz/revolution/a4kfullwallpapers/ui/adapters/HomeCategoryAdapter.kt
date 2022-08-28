package uz.revolution.a4kfullwallpapers.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.revolution.a4kfullwallpapers.ui.home.CategoryFragment
import uz.revolution.a4kfullwallpapers.ui.models.Category

class HomeCategoryAdapter(var data: ArrayList<Category>, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Fragment {
        return CategoryFragment.newInstance(data[position].imageList)
    }

}