package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by jennifernghinguyen on 2/21/17.
 */

public final class PetContract {

    public PetContract(){

    }
    public static final class PetsEntry implements BaseColumns{
        public static final String TABLE_NAME = "pets";

        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_WEIGHT = "weight";
        public static final String COLUMN_PET_GENDER = "gender";

        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_UNKNOWN = 0;
    }
}
