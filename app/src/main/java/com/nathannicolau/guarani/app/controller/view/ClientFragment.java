package com.nathannicolau.guarani.app.controller.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.nathannicolau.guarani.R;


public class ClientFragment extends Fragment {

    private TabLayout tabLayoutClientes;
    private ViewPager2 viewPagerClientes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        setupViews(view);
        setNavigation();
        return view;
    }

    private void setupViews(View view) {
        this.tabLayoutClientes = view.findViewById(R.id.tab_layout_clientes);
        this.viewPagerClientes = view.findViewById(R.id.view_pager_clientes);
    }

    private void setNavigation() {


        viewPagerClientes.setAdapter(new FragmentStateAdapter(getParentFragmentManager(), getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new PesquisaClientesFragment();
                    case 1:
                        return new CadastroClienteFragment();
                }
                return null;
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        viewPagerClientes.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                tabLayoutClientes.selectTab(tabLayoutClientes.getTabAt(position));
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        tabLayoutClientes.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerClientes.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}