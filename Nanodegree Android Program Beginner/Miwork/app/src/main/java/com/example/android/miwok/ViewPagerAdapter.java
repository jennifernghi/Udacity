package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new NumberFragment();
        }else if (position==1){
            return new FamilyFragment();
        }else if(position==2){
            return new ColorsFragments();
        }else{
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if(position==0){
            return "Numbers";
        }else if (position==1){
            return "Family";
        }else if(position==2){
            return "Colors";
        }else{
            return "Phrases";
        }
    }
}
