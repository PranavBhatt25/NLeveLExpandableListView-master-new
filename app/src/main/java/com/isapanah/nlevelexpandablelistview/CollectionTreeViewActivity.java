package com.isapanah.nlevelexpandablelistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.isapanah.nlevelexpandablelistview.nLevel.NLevelAdapter;
import com.isapanah.nlevelexpandablelistview.nLevel.NLevelItem;
import com.isapanah.nlevelexpandablelistview.nLevel.NLevelView;
import com.isapanah.nlevelexpandablelistview.nLevel.SomeObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CollectionTreeViewActivity extends AppCompatActivity {

    List<NLevelItem> list;
    ListView listView;
    String TAG = "CollectionTreeViewActivity ::";
    TextView tv_view_all;
    LinearLayout ll_view_all;

    int[] colors = {Color.BLUE, Color.RED, Color.MAGENTA, Color.GRAY, Color.GREEN, Color.YELLOW};
    // String jsonStringList = "[{\"id\":86,\"collection_id\":\"58565328949\",\"collection_name\":\"Accessories\",\"parent_collection_id\":\"58565328949\",\"shop_id\":1,\"title\":\"Accessories\",\"tags\":\"collection_58565328949\",\"level\":\"0\",\"position\":3,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Accessories.png?v=1536990914\",\"created_at\":\"2020-01-22 11:27:07\",\"updated_at\":\"2020-01-22 11:27:07\",\"children\":[{\"id\":86,\"collection_id\":\"58565328949\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58565328949\",\"shop_id\":1,\"title\":\"Accessories\",\"tags\":\"collection_58565328949\",\"level\":\"0\",\"position\":3,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Accessories.png?v=1536990914\",\"created_at\":\"2020-01-22 11:27:07\",\"updated_at\":\"2020-01-22 11:27:07\",\"children\":[]},{\"id\":93,\"collection_id\":\"58540261429\",\"collection_name\":\"Clutches\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Clutches\",\"tags\":\"collection_58540261429\",\"level\":\"1\",\"position\":10,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Clutches.jpg?v=1536847925\",\"created_at\":\"2020-01-22 11:38:46\",\"updated_at\":\"2020-01-22 11:38:46\",\"children\":[{\"id\":93,\"collection_id\":\"58540261429\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Clutches\",\"tags\":\"collection_58540261429\",\"level\":\"1\",\"position\":10,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Clutches.jpg?v=1536847925\",\"created_at\":\"2020-01-22 11:38:46\",\"updated_at\":\"2020-01-22 11:38:46\",\"children\":[]}]},{\"id\":94,\"collection_id\":\"58540228661\",\"collection_name\":\"Handbags\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Handbags\",\"tags\":\"collection_58540228661\",\"level\":\"1\",\"position\":11,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Handbags.jpg?v=1536847756\",\"created_at\":\"2020-01-22 11:39:10\",\"updated_at\":\"2020-01-22 11:39:10\",\"children\":[{\"id\":94,\"collection_id\":\"58540228661\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Handbags\",\"tags\":\"collection_58540228661\",\"level\":\"1\",\"position\":11,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Handbags.jpg?v=1536847756\",\"created_at\":\"2020-01-22 11:39:10\",\"updated_at\":\"2020-01-22 11:39:10\",\"children\":[]}]},{\"id\":95,\"collection_id\":\"58540195893\",\"collection_name\":\"Artificial Jewellery\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"1\",\"position\":12,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-01-22 11:39:47\",\"updated_at\":\"2020-01-22 11:39:47\",\"children\":[{\"id\":95,\"collection_id\":\"58540195893\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"1\",\"position\":12,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-01-22 11:39:47\",\"updated_at\":\"2020-01-22 11:39:47\",\"children\":[]}]}]},{\"id\":90,\"collection_id\":\"58565230645\",\"collection_name\":\"Lingerie & Sleepwear\",\"parent_collection_id\":\"58565230645\",\"shop_id\":1,\"title\":\"Lingerie & Sleepwear\",\"tags\":\"collection_58565230645\",\"level\":\"0\",\"position\":7,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lingerie_Sleepwear.jpg?v=1536989825\",\"created_at\":\"2020-01-22 11:33:11\",\"updated_at\":\"2020-01-22 11:33:11\",\"children\":[{\"id\":90,\"collection_id\":\"58565230645\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58565230645\",\"shop_id\":1,\"title\":\"Lingerie & Sleepwear\",\"tags\":\"collection_58565230645\",\"level\":\"0\",\"position\":7,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lingerie_Sleepwear.jpg?v=1536989825\",\"created_at\":\"2020-01-22 11:33:11\",\"updated_at\":\"2020-01-22 11:33:11\",\"children\":[]},{\"id\":99,\"collection_id\":\"58539737141\",\"collection_name\":\"Panties\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Panties\",\"tags\":\"collection_58539737141\",\"level\":\"1\",\"position\":16,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Panties.jpg?v=1536845654\",\"created_at\":\"2020-01-22 11:41:29\",\"updated_at\":\"2020-01-22 11:41:29\",\"children\":[{\"id\":99,\"collection_id\":\"58539737141\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Panties\",\"tags\":\"collection_58539737141\",\"level\":\"1\",\"position\":16,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Panties.jpg?v=1536845654\",\"created_at\":\"2020-01-22 11:41:29\",\"updated_at\":\"2020-01-22 11:41:29\",\"children\":[]}]},{\"id\":100,\"collection_id\":\"58538819637\",\"collection_name\":\"Bras\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Bras\",\"tags\":\"collection_58538819637\",\"level\":\"1\",\"position\":17,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Bras.jpg?v=1536845363\",\"created_at\":\"2020-01-22 11:41:45\",\"updated_at\":\"2020-01-22 11:41:45\",\"children\":[{\"id\":100,\"collection_id\":\"58538819637\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Bras\",\"tags\":\"collection_58538819637\",\"level\":\"1\",\"position\":17,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Bras.jpg?v=1536845363\",\"created_at\":\"2020-01-22 11:41:45\",\"updated_at\":\"2020-01-22 11:41:45\",\"children\":[]}]}]},{\"id\":91,\"collection_id\":\"58540392501\",\"collection_name\":\"Heels\",\"parent_collection_id\":\"58540392501\",\"shop_id\":1,\"title\":\"Heels\",\"tags\":\"collection_58540392501\",\"level\":\"0\",\"position\":8,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Heels.jpg?v=1536848224\",\"created_at\":\"2020-01-22 11:36:46\",\"updated_at\":\"2020-01-22 11:36:46\",\"children\":[{\"id\":91,\"collection_id\":\"58540392501\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58540392501\",\"shop_id\":1,\"title\":\"Heels\",\"tags\":\"collection_58540392501\",\"level\":\"0\",\"position\":8,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Heels.jpg?v=1536848224\",\"created_at\":\"2020-01-22 11:36:46\",\"updated_at\":\"2020-01-22 11:36:46\",\"children\":[]}]},{\"id\":92,\"collection_id\":\"58540294197\",\"collection_name\":\"Flats\",\"parent_collection_id\":\"58540294197\",\"shop_id\":1,\"title\":\"Flats\",\"tags\":\"collection_58540294197\",\"level\":\"0\",\"position\":9,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Flats.jpg?v=1536848083\",\"created_at\":\"2020-01-22 11:38:20\",\"updated_at\":\"2020-01-22 11:38:20\",\"children\":[{\"id\":92,\"collection_id\":\"58540294197\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58540294197\",\"shop_id\":1,\"title\":\"Flats\",\"tags\":\"collection_58540294197\",\"level\":\"0\",\"position\":9,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Flats.jpg?v=1536848083\",\"created_at\":\"2020-01-22 11:38:20\",\"updated_at\":\"2020-01-22 11:38:20\",\"children\":[]}]},{\"id\":117,\"collection_id\":\"58540130357\",\"collection_name\":\"Lehenga Choli\",\"parent_collection_id\":\"58540130357\",\"shop_id\":1,\"title\":\"lehenga choli\",\"tags\":\"collection_58540130357,CT_lehenga choli\",\"level\":\"0\",\"position\":18,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lehenga_Choli.jpg?v=1536847313\",\"created_at\":\"2020-01-23 11:30:42\",\"updated_at\":\"2020-01-23 11:30:42\",\"children\":[{\"id\":117,\"collection_id\":\"58540130357\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58540130357\",\"shop_id\":1,\"title\":\"lehenga choli\",\"tags\":\"collection_58540130357,CT_lehenga choli\",\"level\":\"0\",\"position\":18,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lehenga_Choli.jpg?v=1536847313\",\"created_at\":\"2020-01-23 11:30:42\",\"updated_at\":\"2020-01-23 11:30:42\",\"children\":[]}]},{\"id\":325,\"collection_id\":\"58540195893\",\"collection_name\":\"Artificial Jewellery\",\"parent_collection_id\":\"58540195893\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"0\",\"position\":19,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-05-18 10:20:44\",\"updated_at\":\"2020-05-18 10:20:44\",\"children\":[{\"id\":325,\"collection_id\":\"58540195893\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58540195893\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"0\",\"position\":19,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-05-18 10:20:44\",\"updated_at\":\"2020-05-18 10:20:44\",\"children\":[]}]}]";
    String jsonStringList = "[{\"id\":86,\"collection_id\":\"58565328949\",\"collection_name\":\"Accessories\",\"parent_collection_id\":\"58565328949\",\"shop_id\":1,\"title\":\"Accessories\",\"tags\":\"collection_58565328949\",\"level\":\"0\",\"position\":3,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Accessories.png?v=1536990914\",\"created_at\":\"2020-01-22 11:27:07\",\"updated_at\":\"2020-01-22 11:27:07\",\"children\":[{\"id\":86,\"collection_id\":\"58565328949\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58565328949\",\"shop_id\":1,\"title\":\"Accessories\",\"tags\":\"collection_58565328949\",\"level\":\"0\",\"position\":3,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Accessories.png?v=1536990914\",\"created_at\":\"2020-01-22 11:27:07\",\"updated_at\":\"2020-01-22 11:27:07\",\"children\":[]},{\"id\":93,\"collection_id\":\"58540261429\",\"collection_name\":\"Clutches\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Clutches\",\"tags\":\"collection_58540261429\",\"level\":\"1\",\"position\":10,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Clutches.jpg?v=1536847925\",\"created_at\":\"2020-01-22 11:38:46\",\"updated_at\":\"2020-01-22 11:38:46\",\"children\":[{\"id\":93,\"collection_id\":\"58540261429\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Clutches\",\"tags\":\"collection_58540261429\",\"level\":\"1\",\"position\":10,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Clutches.jpg?v=1536847925\",\"created_at\":\"2020-01-22 11:38:46\",\"updated_at\":\"2020-01-22 11:38:46\",\"children\":[]}]},{\"id\":94,\"collection_id\":\"58540228661\",\"collection_name\":\"Handbags\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Handbags\",\"tags\":\"collection_58540228661\",\"level\":\"1\",\"position\":11,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Handbags.jpg?v=1536847756\",\"created_at\":\"2020-01-22 11:39:10\",\"updated_at\":\"2020-01-22 11:39:10\",\"children\":[{\"id\":94,\"collection_id\":\"58540228661\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Handbags\",\"tags\":\"collection_58540228661\",\"level\":\"1\",\"position\":11,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Handbags.jpg?v=1536847756\",\"created_at\":\"2020-01-22 11:39:10\",\"updated_at\":\"2020-01-22 11:39:10\",\"children\":[]}]},{\"id\":95,\"collection_id\":\"58540195893\",\"collection_name\":\"Artificial Jewellery\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"1\",\"position\":12,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-01-22 11:39:47\",\"updated_at\":\"2020-01-22 11:39:47\",\"children\":[{\"id\":95,\"collection_id\":\"58540195893\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"1\",\"position\":12,\"parent_id\":\"86\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-01-22 11:39:47\",\"updated_at\":\"2020-01-22 11:39:47\",\"children\":[]}]}]},{\"id\":90,\"collection_id\":\"58565230645\",\"collection_name\":\"Lingerie & Sleepwear\",\"parent_collection_id\":\"58565230645\",\"shop_id\":1,\"title\":\"Lingerie & Sleepwear\",\"tags\":\"collection_58565230645\",\"level\":\"0\",\"position\":7,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lingerie_Sleepwear.jpg?v=1536989825\",\"created_at\":\"2020-01-22 11:33:11\",\"updated_at\":\"2020-01-22 11:33:11\",\"children\":[{\"id\":90,\"collection_id\":\"58565230645\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58565230645\",\"shop_id\":1,\"title\":\"Lingerie & Sleepwear\",\"tags\":\"collection_58565230645\",\"level\":\"0\",\"position\":7,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lingerie_Sleepwear.jpg?v=1536989825\",\"created_at\":\"2020-01-22 11:33:11\",\"updated_at\":\"2020-01-22 11:33:11\",\"children\":[]},{\"id\":99,\"collection_id\":\"58539737141\",\"collection_name\":\"Panties\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Panties\",\"tags\":\"collection_58539737141\",\"level\":\"1\",\"position\":16,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Panties.jpg?v=1536845654\",\"created_at\":\"2020-01-22 11:41:29\",\"updated_at\":\"2020-01-22 11:41:29\",\"children\":[{\"id\":99,\"collection_id\":\"58539737141\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Panties\",\"tags\":\"collection_58539737141\",\"level\":\"1\",\"position\":16,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Panties.jpg?v=1536845654\",\"created_at\":\"2020-01-22 11:41:29\",\"updated_at\":\"2020-01-22 11:41:29\",\"children\":[]}]},{\"id\":100,\"collection_id\":\"58538819637\",\"collection_name\":\"Bras\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Bras\",\"tags\":\"collection_58538819637\",\"level\":\"1\",\"position\":17,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Bras.jpg?v=1536845363\",\"created_at\":\"2020-01-22 11:41:45\",\"updated_at\":\"2020-01-22 11:41:45\",\"children\":[{\"id\":100,\"collection_id\":\"58538819637\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"\",\"shop_id\":1,\"title\":\"Bras\",\"tags\":\"collection_58538819637\",\"level\":\"1\",\"position\":17,\"parent_id\":\"90\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Bras.jpg?v=1536845363\",\"created_at\":\"2020-01-22 11:41:45\",\"updated_at\":\"2020-01-22 11:41:45\",\"children\":[]}]}]},{\"id\":91,\"collection_id\":\"58540392501\",\"collection_name\":\"Heels\",\"parent_collection_id\":\"58540392501\",\"shop_id\":1,\"title\":\"Heels\",\"tags\":\"collection_58540392501\",\"level\":\"0\",\"position\":8,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Heels.jpg?v=1536848224\",\"created_at\":\"2020-01-22 11:36:46\",\"updated_at\":\"2020-01-22 11:36:46\",\"children\":[{\"id\":91,\"collection_id\":\"58540392501\",\"collection_name\":\"Explore All\",\"parent_collection_id\":\"58540392501\",\"shop_id\":1,\"title\":\"Heels\",\"tags\":\"collection_58540392501\",\"level\":\"0\",\"position\":8,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Heels.jpg?v=1536848224\",\"created_at\":\"2020-01-22 11:36:46\",\"updated_at\":\"2020-01-22 11:36:46\",\"children\":[]}]},{\"id\":92,\"collection_id\":\"58540294197\",\"collection_name\":\"Flats\",\"parent_collection_id\":\"58540294197\",\"shop_id\":1,\"title\":\"Flats\",\"tags\":\"collection_58540294197\",\"level\":\"0\",\"position\":9,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Flats.jpg?v=1536848083\",\"created_at\":\"2020-01-22 11:38:20\",\"updated_at\":\"2020-01-22 11:38:20\",\"children\":[]},{\"id\":117,\"collection_id\":\"58540130357\",\"collection_name\":\"Lehenga Choli\",\"parent_collection_id\":\"58540130357\",\"shop_id\":1,\"title\":\"lehenga choli\",\"tags\":\"collection_58540130357,CT_lehenga choli\",\"level\":\"0\",\"position\":18,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Lehenga_Choli.jpg?v=1536847313\",\"created_at\":\"2020-01-23 11:30:42\",\"updated_at\":\"2020-01-23 11:30:42\",\"children\":[]},{\"id\":325,\"collection_id\":\"58540195893\",\"collection_name\":\"Artificial Jewellery\",\"parent_collection_id\":\"58540195893\",\"shop_id\":1,\"title\":\"Artificial Jewellery\",\"tags\":\"collection_58540195893\",\"level\":\"0\",\"position\":19,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/0063\\/1324\\/6773\\/collections\\/Artificial_Jewellery.jpg?v=1536994314\",\"created_at\":\"2020-05-18 10:20:44\",\"updated_at\":\"2020-05-18 10:20:44\",\"children\":[]}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_treeview);

        NLevelExpandableListView();

    }

    private void NLevelExpandableListView() {

        tv_view_all = (TextView) findViewById(R.id.tv_view_all);
        ll_view_all = (LinearLayout) findViewById(R.id.ll_view_all);
        listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<NLevelItem>();
        final LayoutInflater inflater = LayoutInflater.from(this);
        nestedLoop(jsonStringList, null, inflater, 0);

        NLevelAdapter adapter = new NLevelAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ((NLevelAdapter) listView.getAdapter()).toggle(arg2);
                ((NLevelAdapter) listView.getAdapter()).getFilter().filter();
            }
        });

        tv_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CollectionTreeViewActivity.this, "View All clicked...", Toast.LENGTH_SHORT).show();
            }
        });
        ll_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CollectionTreeViewActivity.this, "View All clicked...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void nestedLoop(String levelList, NLevelItem nLevelItem, final LayoutInflater inflater, int level) {
        try {
            JSONArray jsonArrayStringList = new JSONArray(levelList);
            int length = jsonArrayStringList.length();
            Log.e(TAG, "jsonArrayStringList length = " + length);
            for (int i = 0; i < length; i++) {
                JSONObject itemObject = jsonArrayStringList.getJSONObject(i);
                Log.e(TAG, "itemObject >>" + i + " :: " + itemObject.toString());
                if (itemObject.toString().contains("children")) {
                    int childrenSize = itemObject.getJSONArray("children").length();
                    Log.e(TAG, "itemObject contains >>" + childrenSize);


                    NLevelItem Parent = itemView(i, itemObject.getString("collection_name"), nLevelItem, inflater, level, !(childrenSize > 0));
                    Parent.setTag(itemObject.getString("tags"));
                    Parent.setTitle(itemObject.getString("collection_name"));
                    list.add(Parent);

                    if (childrenSize > 0) {
                        Log.e(TAG, "=================================================================================");
                        nestedLoop(itemObject.getJSONArray("children").toString(), Parent, inflater, level + 1);
                    }
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "Exception :: " + e.toString());
        }
    }

    private NLevelItem itemView(final int itemRow, final String Title, final NLevelItem nLevelItem, final LayoutInflater inflater, final int level, final boolean isLast) {

        final NLevelItem superChild = new NLevelItem(new SomeObject(Title), nLevelItem, new NLevelView() {
            @Override
            public View getView(NLevelItem item) {
                try {
                    View view = inflater.inflate(R.layout.list_item_treeview, null);
                    final TextView tv = (TextView) view.findViewById(R.id.textView);
                    final RelativeLayout rr_address_add = (RelativeLayout) view.findViewById(R.id.rr_address_add);
                    final ImageView ic_tree_view_icon = (ImageView) view.findViewById(R.id.ic_tree_view_icon);

                    String name = (String) ((SomeObject) item.getWrappedObject()).getName();

                    if (item != null && item.getTitle() != null && item.getTitle().length() > 0) {
                        if (item.isExpanded()) {
                            if (!item.getTitle().equalsIgnoreCase("Explore All")) {
                                ic_tree_view_icon.setBackgroundResource(R.mipmap.ic_minus);
                            }
                        } else {
                            if (!item.getTitle().equalsIgnoreCase("Explore All")) {
                                ic_tree_view_icon.setBackgroundResource(R.mipmap.add_address);
                            }
                        }
                        tv.setText(item.getTitle());
                        tv.setBackgroundColor(colors[level]);
                    }
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) tv.getLayoutParams();
                    mlp.setMargins(level * 50, 5, 5, 5);

                    if (isLast) {
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(CollectionTreeViewActivity.this, "Tag: " + nLevelItem.getTag(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    return view;
                } catch (Exception e) {
                    e.getStackTrace();
                }
                return null;
            }
        });
        return superChild;
    }
}
