package com.example.shafy.dolabelkhedma.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafy on 19/10/2017.
 */

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        /*ContentValues cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,2 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,3 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,4 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,5 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,6 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,7 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,8 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,9 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv=new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,12 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,13 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,14 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,1 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,15 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,2 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,16 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,2 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,17 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,2 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,18 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,0 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,3 );
        list.add(cv);

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,19 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH ,1 );
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,3 );
        list.add(cv);*/

        //2ola wlad

        ContentValues cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابانوب يوسف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," ش عبدالفتاح النجار من ش على بن ابي طالب – الملكة امتداد ش العدوي من المساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-10-10");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابرام هاني ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 39ش علي عبد النبي – المسمط – الملكة ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-07-20");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," امير ابراهيم كامل ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 31ش ابو النجا من الشهيد حمدي كلية التربية الرياضية ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"23-04-2005");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," امير اسحق ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 12ش احمداسماعيل – المساكن 6");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-04-16");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," امير عادل عزمي ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 12ش احمد على دياب من على بن ابي طالب موازي لجمال عبد الناصر - مساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-07-25");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," اندرو نظمي سرور ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 17ش العشرين – فيصل ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-12-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," باسم سامح ملاك ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 48ش عبد المنعم محمود – المساحة - ناصية الشارع من المساكن خضري و علاف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-12-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," برسوم ماجد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 7ش طلعت شحاتة ناهيا ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-05-05");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بولا جمال ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 23ش احمد حمدي البنا شارع العدوي – جنب مكتبة سكر بنات - مساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-10-24");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بولا هاني بطرس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 8ش عبده فهين من جمال عبد الناصر -  ناصية الحنفية من المساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-10-30");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);

        //tanya wlad

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابانوب صلاح مرقس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 21ش محمد عبد الفتاح النجار من ش على بن أبى طالب - الملكة - امتداد ش العدوى من المساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-01-07");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابرام مراد اسحق ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 23ش ابراهيم الدسوقى من ش على بن أبى طالب - الملكة - دور 3 - شقة 3");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-07-01");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابراهيم عبيد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 1ش صابر متولى - العشرين ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-07-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," استيفن رفعت ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 5ش ابراهيم عبد المجيد من ش جمال عبد الناصر - مساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-11-11");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," انجيلو وائل فاروق ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 3ش طايل أحمد جبر - الملكة - ناصية ماركت فونتانا - دور 6 - شقة 11");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-08-27");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," اندراوس بهيج وديع ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"1 ش حسين البحيرى من ش الانصارى - العشرين ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        // YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ايهاب موسى فريز ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"13 ش عبد الله محمود متفرع من الملكة أمام ناصية القهوة و العصير - الحنفية - الشارع قبل أول العنقود ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-01-01");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بضابا جرجس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"40 ش حمادة العجمى - ناصية حدايد وبويات من المساكن بعد مسمط -  الارضى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-01-28");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بولا ماجد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 17ش ابو النجا -  الناصية مصطفى للموبيلات - امام فرع مارجرجس والانبا ابرام ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        // YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بولا هانى شحاتة ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 3ش محمد رمضان - العشرين - ناصية سنتر تبارك - أمام فرن الاسيوطى - دور 1 ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-05-04");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);

        //talta wlad

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابانوب سامى عازر ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 49ش مسجد حسن رخا –ناصية مسمط الحرمين من ش المساكن امام نقطة الاسعاف شقة 3 ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-06-07");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابانوب عيد ثابت ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 14ش مصطفى الجرجاوى متفرع من جمال عبد الناصر");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-03-07");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ابراهيم ناجح فهيم ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 34ش محمد عبد الفتاح النجار من ش على بن ابى طالب- الملكة –فيصل –امتداد ش العدوى من المساكن الدور الاول شقة 1");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-05-15");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," امير وليد تواضروس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 21ش عبد السلام منسى من الشهيد احمد حمدى الدور الثاني مساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-02-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," اندرو سمير حنا ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"10 ش محمد الصغير من ش على بن ابى طالب من جمال عبد الناصر –المساكن الدور الارضي ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-09-04");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," اندرو مدحت وليم ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 22ش محمد المنسى من ش الملكة الدور السادس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-04-04");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بطرس صبحى عزمى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 10ش محمد الصغير من ش على بن ابى طالب من جمال عبد الناصر –المساكن الدور الاول ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-07-21");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بولا وجيه الفي روفائيل ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 13ش محمد ابو النجا امام كلية التربية الرياضية الدور الاول يمي");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-12-25");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بيتر رافت خليل ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 2حارة عطية زيدان من ش محمد حسن كمال من ش على بن ابى طالب –الملكة  الدور الارضي      شقة 1");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-11-15");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بيتر مجدى ابراهيم ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 5ش ابراهيم عبد المجيد من ش جمال عبد الناصر –المساكن –فيصل الدور الرابع شقة 6 ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-07-23");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,1);
        list.add(cv);

        //2ola bnat

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," أميرة إبراهيم ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 131ش أبو النجا من الشهيد حمدى كلية التربية الرياضية ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-04-24");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," إيفلن جمال فؤاد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 28ش إبراهيم عبد المجيد من ش جمال عبد الناصر ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-04-13");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," إيفلين منير ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 18ش الشهيد فتحى متفرع من ش على بن أبى طالب – ملكة 1");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-11-15");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بسمة باسم بشرى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 5ش فارس قاسم من ش الكشافة – العشرين عند مخبز الأسيوطى – دور 3 ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        // YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جوليا طونى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        // YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جومانا صبرى عبد الله ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 24ش صالح قناوى – فيصل – مدكور ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-02-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جومانا ناير ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 2ش مسجد الرحمة بعد ش الكنيسة – العشرين دور 9");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-11-28");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جويس جرجس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 3ش إبراهيم عطية من الشرفا – فيصل ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-12-07");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جيسيكا جوزيف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"15 ش مجاهد الصناديلي من ش جمال عبد الناصر – مساكن ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-10-16");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جيسيكا ماجد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 2ش محمد جلال أمام فيكتوريا عيون مصر – مكتب بولاق - العشرين ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,1);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-10-29");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        //tnay bnat

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME,"أميرة جاد قلينى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 28ش الجزائر - بعد أبو شريف قدام  المغسلة الفرنسية - الدور الرابع ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-11-10");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," انجى أنور بخيت");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 25ش محمد عبد الفتاح النجار من ش على بن أبى طالب - المساكن - أول الشارع مخبز سويت هوم من جمال عبد الناصر ");
                cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-02-19");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," انجى مجدى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 5ش أحمد ماهر أول فيصل - دور 2");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-01-07");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بسنت ناجح عوض ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 3ش حارة الوسطانى - شارع العشرين - شارع ابو زيد قهوة الوسطانى - بعد كشرى العمدة ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-05-09");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جوليا فرج ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 23ش أبو زيد من وصية الجمل العشرين - دور 3");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-02-10");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ساندى سيدهم ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 2ش مسجد الصحابة  - أمام بلوك 30 - المساكن 3");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-07-5");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ساندى فرح عزيز ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 37ش عبد المنعم رياض - فيصل - مدكور ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-11-04");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," كلارا وهيب ظريف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS,"10 ش عبده فهيم من جمال عبد الناصر - المساكن - على ناصية الحنفية ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-06-21");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," كيرمينا عريان ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 7ش عبد الحميد الصعيدى أمام الكنيسة - المساكن - دور 2 - شقة 2");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2005-02-08");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," كيرمينا هانى فوزى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 14ش  ابراهيم نافع - دور 6 - اول الشارع بيتزا المهندس - امام صيدلية عبير ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-12-08");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);
        
        //talta bnat

        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," الينا الامير عياد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 7ش فتوح يوسف - فيصل - مدكور ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-03-14");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," أميرة تادرس لويس ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 9ش الشيخ ياسين من على بن أبى طالب - الملكة - فيصل - دور الاول ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-10-08");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," أميرة جاد ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 28ش الجزائر ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        // YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);



        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," أن أشرف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," ش عبد السلام عمار - مسجد قباء - المساكن ( أوله ) - دور 6");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-10-12");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بسنت فتحى شوقى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 16ش عبد الله محمود متفرع من الملكة أامام ناصية القهوة و العصير (الحنفية ) قبل أول العنقود - الثانى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-02-23");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بسنت ناصر فايز ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 25ش عبد الحميد الصعيدى - جمال عبد الناصر - امتداد ش الكنيسة - مساكن - دور 2 - شقة 3الثانى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-09-03");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," بسنت وجيه فوزى ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 11ش سيد طه سمكرى من ش جمال عبد الناصر - المساكن - شقة 6");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-07-02");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," جوليا رومانى شنودة ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 26ش محمد أبو زيد من ش جمال عبد الناصر - المساكن  فيصل - دور 1 ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2003-06-26");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ريم نصرى صديق نصيف ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 17ش ابراهيم حسنى من ش جمال عبد الناصر - مساكن - فيصل  - دور 62");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,2);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2002-12-13");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);


        cv = new ContentValues();
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME," ريموندا رفيق شفيق ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS," 22ش محمد عبد الفتاح النجار من ش على بن أبى طال - فيصل - امتداد ش العدوى -مساكن - دور الاخير عبير ");
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class,3);
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB,"2004-03-21");// YYYY-MM-DD
        cv.put(DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER,0);
        list.add(cv);
        

        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (DolabElKhedmaContract.MainDataEnrty.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(DolabElKhedmaContract.MainDataEnrty.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}
