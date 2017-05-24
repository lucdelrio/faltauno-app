package com.app.faltauno.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPageAdapter extends FragmentPagerAdapter{

    public TabsPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public Fragment getItem(int position){
        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "Partidos Disponibles";
            case 1:
                return "Buscar Partidos";
            case 2:
                return "Perfil del Jugador";
            default:
                return null;
        }
    }
}