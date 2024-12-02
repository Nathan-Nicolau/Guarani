package com.nathannicolau.guarani.app.controller.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.nathannicolau.guarani.R;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupView();
        setupFragmentPadrao();
        setupNavigation();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    private void setupView() {
        this.navigationView = findViewById(R.id.nav_view);
        this.drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void setupNavigation() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.entrar, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.nav_home) {
                navigateFragment(new HomeFragment());
            } else if(item.getItemId() == R.id.nav_cliente) {
                navigateFragment(new ClientFragment());
            } else if(item.getItemId() == R.id.nav_produtos) {
                navigateFragment(new ProdutoFragment());
            } else if(item.getItemId() == R.id.nav_sair) {
                showDialogLogout();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
        toggle.syncState();
    }

    private void setupFragmentPadrao() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    private void navigateFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment).commit();
    }
     private void showDialogLogout() {
         Dialog dialog = new Dialog(this);
         dialog.setContentView(R.layout.dialog_logout);

         dialog.getWindow().setLayout(
                 (int) (getResources().getDisplayMetrics().widthPixels * 0.9),
                 ViewGroup.LayoutParams.WRAP_CONTENT
         );

         MaterialButton btnConfirmar = dialog.findViewById(R.id.btn_confirmar_saida);
         MaterialButton btnCancelar = dialog.findViewById(R.id.btn_cancelar_saida);

         btnConfirmar.setOnClickListener(v -> {
             dialog.dismiss();
             finish();
         });

         btnCancelar.setOnClickListener(v -> {
             dialog.dismiss();
         });

         dialog.show();

     }


}