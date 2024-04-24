package org.rmj.guanzongroup.gconnect.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.rmj.guanzongroup.gconnect.Fragment.Fragment_Home;
import org.rmj.guanzongroup.gconnect.Fragment.Fragment_MCProducts;
import org.rmj.guanzongroup.gconnect.Fragment.Fragment_MPhones;

public class ProductSlider_Adapter extends FragmentStateAdapter {
    public ProductSlider_Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Fragment_MCProducts();
            case 1:
                return new Fragment_MPhones();
            default:
                return new Fragment_MCProducts();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
