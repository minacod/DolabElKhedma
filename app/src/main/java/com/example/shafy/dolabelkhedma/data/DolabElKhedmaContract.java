package com.example.shafy.dolabelkhedma.data;

import android.provider.BaseColumns;

/**
 * Created by shafy on 19/10/2017.
 */

public class DolabElKhedmaContract {

    public static final class AttendanceEntry implements BaseColumns{

        public static final String TABLE_NAME="attendance";
        public static final String _ID = "attendance_id";
        public static final String COLUMNS_Date="date";
        public static final String COLUMNS_PERSON_ID="person_id";
        public static final String COLUMNS_Class="class_number";
        //test only
        public static final String COLUMNS_CH="chk";

    }

    public static final class MainDataEnrty implements BaseColumns{

        public static final String TABLE_NAME ="main_data";
        public static final String COLUMNS_NAME ="name";
        public static final String COLUMNS_ADDRESS ="address";
        public static final String COLUMNS_DOB ="dob";
        public static final String COLUMNS_GENDER ="gender";
        public static final String COLUMNS_Class="class_number";
        public static final String COLUMNS_COINS_COUNT ="coins_count";
    }

    public static final class TelephonesEntry implements BaseColumns{

        public static final String TABLE_NAME ="telephones";
        public static final String COLUMNS_PERSON_ID ="person_id";
        public static final String COLUMNS_PHONE_NUMBER ="phone_number";
        public static final String COLUMNS_PHONE_HOLDER ="phone_holder";    //m mother   f father   k kid
    }

}
