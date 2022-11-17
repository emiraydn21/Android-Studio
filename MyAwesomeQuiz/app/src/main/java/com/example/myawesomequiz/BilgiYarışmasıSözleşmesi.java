package com.example.myawesomequiz;

import android.provider.BaseColumns;

public final class BilgiYarışmasıSözleşmesi {

    private BilgiYarışmasıSözleşmesi(){}

    public static class SoruTablosu implements BaseColumns {
        public static final String TABLO_ADI = "sınav_soruları";
        public static final String SÜTUN_SORUSU = "soru";
        public static final String SÜTUN_SEÇENEĞİ1 = "seçenek1";
        public static final String SÜTUN_SEÇENEĞİ2 = "seçenek2";
        public static final String SÜTUN_SEÇENEĞİ3 = "seçenek3";
        public static final String SÜTUN_CEVAP_NR = "cevap_nr";
    }
}
