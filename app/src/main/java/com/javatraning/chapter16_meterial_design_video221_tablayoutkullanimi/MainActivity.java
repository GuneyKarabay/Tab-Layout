package com.javatraning.chapter16_meterial_design_video221_tablayoutkullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    private ArrayList<Fragment>fragmentListesi = new ArrayList<>();
    private ArrayList<String>fragmentBaslikListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);

        fragmentListesi.add(new FragmentBirinci());
        fragmentListesi.add(new FragmentIkinci());
        fragmentListesi.add(new FragmentUcuncu());


        //Fragmentleri içinde göstereceğimiz viewpageradapter için tanımlama yaptık.

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);

        viewPager2.setAdapter(adapter);             //fragmentleri gösterdik.


        //Fragment Başlıklarını ekliyoruz.

        fragmentBaslikListesi.add("Bir");
        fragmentBaslikListesi.add("İki");
        fragmentBaslikListesi.add("Üç");


        //Tab layoutu viewpager2 ile çalıştırmak için attach ile bağladık.

        new TabLayoutMediator(tabLayout,viewPager2,
                (tab,position)->tab.setText(fragmentBaslikListesi.get(position))).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.resim1);

    }

    private class  MyViewPagerAdapter extends FragmentStateAdapter{

        //Tek en üstteki dolu constructor
        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentListesi.get(position);    //Fragmentleri organize edeceği pozisyonu tanımladık.
        }

        @Override
        public int getItemCount() {
            return fragmentListesi.size();        //Kaç fragment varsa onu geri döndürür o kadar işlem yapar.
        }
    }
}