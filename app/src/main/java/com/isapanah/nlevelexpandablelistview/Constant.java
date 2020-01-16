package com.isapanah.nlevelexpandablelistview;

import android.graphics.drawable.Drawable;

public interface Constant {

    int PAGE_SIZE = 20;
    int PAGE_SIZE_2 = 105;
    int COLLECTION_PAGE_SIZE = 50;
    int COLLECTION_PAGE_SIZE_250 = 250;
    int THRESHOLD = 10;
    int CONSTANT_PAGE_SIZE_250 = 250;


    public static final String English = "en";
    public static final String Danish = "da";
    public static final String Dutch = "nl";
    public static final String French = "fr";
    public static final String German = "de";
    public static final String Italian = "it";
    public static final String Japanese = "ja";
    public static final String Portuguese = "pt";
    public static final String Portuguese_BR = "BR";
    public static final String Portuguese_PT = "PT";
    public static final String Spanish = "es";
    public static final String Arabic = "ar";
    public static final String Portuguese_PT_BR = "pt-BR";
    public static final String Portuguese_PT_PT = "pt-PT";
    public static final String Catalan = "ca";
    public static final String Czech = "cs";
    public static final String Greek = "el";
    public static final String Luxembourgish = "de-lu";
    public static final String Norwegian = "nb";
    public static final String Afrikaans = "af";
    public static final String Bangla = "bn";
    public static final String Bosnian_Latin = "bs";
    public static final String Bulgarian = "bg";
    public static final String Cantonese_Traditional = "yue";         //
    public static final String Chinese_Simplified = "zh-Hans";
    public static final String Chinese_Traditional = "zh-Hant";

//    public static final String Chinese_Simplified = "zh_CN";
//    public static final String Chinese_Traditional = "zh_TW";

    public static final String Croatian = "hr";
    public static final String Estonian = "et";
    public static final String Fijian = "fj";
    public static final String Filipino = "fil";
    public static final String Finnish = "fi";
    public static final String Haitian_Creole = "ht";
    //   public static final String Hebrew = "he";
    public static final String Hebrew = "iw";
    public static final String Hindi = "hi";
    public static final String Hmong_Daw = "mww";     //
    public static final String Hungarian = "hu";
    public static final String Icelandic = "is";
    public static final String Indonesian = "in";
    public static final String Kiswahili = "sw";
    public static final String Klingon = "tlh";     //
    public static final String Klingon_plqaD = "tlh-Qaak";   //
    public static final String Korean = "ko";
    public static final String Latvian = "lv";
    public static final String Lithuanian = "lt";
    public static final String Malagasy = "mg";
    public static final String Malay = "ms";
    public static final String Maltese = "mt";
    public static final String Persian = "fa";
    public static final String Polish = "pl";
    public static final String Queretaro_Otomi = "otq";    //
    public static final String Romanian = "ro";
    public static final String Russian = "ru";
    public static final String Samoan = "sm";
    //   public static final String Serbian_Cyrillic = "sr-Cyrl";
    public static final String Serbian_Cyrillic = "sr";
    public static final String Serbian_Latin = "sr-Latn";   //
    public static final String Slovak = "sk";
    public static final String Slovenian = "sl";
    public static final String Swedish = "sv";
    public static final String Tahitian = "ty";
    public static final String Tamil = "ta";
    public static final String Telugu = "te";
    public static final String Thai = "th";
    public static final String Tongan = "to";
    public static final String Turkish = "tr";
    public static final String Ukrainian = "uk";
    public static final String Urdu = "ur";
    public static final String Vietnamese = "vi";
    public static final String Welsh = "cy";
    public static final String Yucatec_Maya = "yua";

    public static final class HEADER {


     //                  public static String IS_LIVE_APP = "Live";
         public static String IS_LIVE_APP = "";

        //                public static String DOMAIN_NAME = "swifteria.myshopify.com";
        //          public static String DOMAIN_NAME = "swifteria.myshopify.com";
        public static String DOMAIN_NAME = "wepdemo6.myshopify.com";
        //      public static String DOMAIN_NAME = "pluschoque-le-soleil.myshopify.com";

//          public static String DOMAIN_NAME = "Demo Product Shopify.myshopify.com";
        // public static String DOMAIN_NAME = "wp-dinesh.myshopify.com";
        //      public static String DOMAIN_NAME = "wp-mobidesign.myshopify.com";
        //  public static String DOMAIN_NAME = "247bestdeals.myshopify.com";

        public static Drawable drawable = null;
        //       public static String ReviewRatingToken = "AU_pCdKFl5kMmKNPKObMwbjbT8U";
        //       public static String ReviewRatingToken = "01s83GR80HdXEEoduzhyXbaa70M";

        public static String MicrosodtAzureKey = "b8a6d327c0e64eda8f25b77987fdfb6d";
        public static String MicrosodtAzureApiURL = "https://dev.microsofttranslator.com/translate?api-version=3.0&from=";
    }

    public static final class MESSAGE {
        public static String CHECK_INTERNET_CONNECTION = "Please Check your internet connection";
        public static final String PROGRESS_PLEASE_WAIT_MSG = "Please Wait...";
        public static final String CONNECTION_TIMEOUT = "Connection timeout";
        public static final String STORE_ERROR = "Your subscription not active";
        public static final String STORE_NOT_FOUND = "Store not found";
        public static final String PASSWORD_WRONG = "Wrong Password";
    }

    public static final class WEB_SERVICE_KEY {
        public static final String FCM_TOKEN = "fcm_token";
        public static final String SHOP_DOMAIN = "shop_domain";
        public static final String DEVICEID = "deviceid";
        public static final String DEVICE_TYPE = "device_type";
        public static final String PASS_COLLECTION_ID = "pass-collection-id";
        public static final String EMAIL_OWNER = "email_owner";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String ORDER_NUMBER = "order_number";
        public static final String DESCRIPTION = "description";
    }

    public static final class URL {
        //       public static final String BASE_URL = "http://webplanex.biz/monkeycart/public";

        public static final String BASE_URL = "https://appbuilderdemo.webplanex.com/api/home?shop=";
        //     public static final String BASE_URL = "https://appbuilder.webplanex.com/api/settings?shop=";

        public static final String BASE_URL_FOR_LANGUAGE = "https://appbuilderdemo.webplanex.com/api/language-settings?shop=";
        public static final String BASE_URL_CANCEL_ORDER = "https://appbuilderdemo.webplanex.com/api/cancel-order?";
        public static final String BASE_URL_REMOVE_WEEKLY_DEALS = "https://appbuilderdemo.webplanex.com/api/remove-app-block";
        public static final String BASE_URL_NOTIFICATION_LISTING = "http://appbuilderdemo.webplanex.com/api/notifications-list?shop=";
        public static final String BASE_URL_COLLECTIONS_LISTING = "https://appbuilderdemo.webplanex.com/api/collection-list?shop=";
        public static final String IMAGE_SEARCH_URL = "https://api.shopixai.com/partners/search";
        public static final String BASE_URL_FCM = "https://appbuilderdemo.webplanex.com";
        public static final String FCM_TOKEN_URL = BASE_URL_FCM + "/apiStore";


        //        public static final String FCM_TOKEN_URL = "https://android.webplanex.biz/apiStore";
//        public static final String SUB_COLLECTION_LIST = "http://webplanex.biz/monkeycart-shopify/public/sub-collection-list";
        public static final String SUB_COLLECTION_LIST = "http://webplanex.biz/monkeycart-shopify/public/sub-collection-list";

    }

    public static final class JSON_KEY {
        public static String CODE = "code";
        public static String STATUS = "status";
        public static String SUCCESS = "success";
        public static String SUB_COLLECTIONS = "sub_collections";
        public static String SUB_COLLECTION_ID = "sub_collection_id";
        public static String MSG = "msg";
        public static String MASSAGE = "message";
        public static String RESPONSE = "response";
        public static String DATA = "data";
        public static String PRODUCT_EXTERNAL_ID = "product_external_id";
        public static String BADGE = "badge";
        public static String ALL_REVIEWS = "all_reviews";
        public static String ALL_REVIEWS_HEADER = "all_reviews_header";
        public static String WIDGET = "widget";
        public static String BLOCK_UNIC_ID = "block_unique_id";
    }
}
