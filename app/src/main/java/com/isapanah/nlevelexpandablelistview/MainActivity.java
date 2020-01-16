package com.isapanah.nlevelexpandablelistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.isapanah.nlevelexpandablelistview.nLevel.NLevelAdapter;
import com.isapanah.nlevelexpandablelistview.nLevel.NLevelItem;
import com.isapanah.nlevelexpandablelistview.nLevel.NLevelView;
import com.isapanah.nlevelexpandablelistview.nLevel.SomeObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<NLevelItem> list;
    ListView listView;

    int[] colors = {Color.BLUE, Color.RED, Color.MAGENTA, Color.GRAY, Color.GREEN, Color.YELLOW};

    String jsonStringList = "{\"status\":1,\"msg\":\"\",\"is_custom_collection\":1,\"collection-list\":[{\"id\":6,\"collection_id\":\"56378982436\",\"collection_name\":\"Mobiles\",\"parent_collection_id\":\"56378982436\",\"shop_id\":24,\"title\":\"mobile_titles\",\"tags\":\"CT_realme,CT_samsung,CT_nokia\",\"level\":\"0\",\"position\":0,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/e5d5dd05841489a766156c845cb90d55d6dafe10_e2a315f5-9225-4209-bc0f-8510817b7bba.jpg?v=1565096757\",\"created_at\":\"2020-01-10 09:21:37\",\"updated_at\":\"2020-01-10 12:08:39\",\"_56378982436\":[{\"id\":8,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"mobile_accessories\",\"tags\":\"CT_cover,CT_charger,CT_tuffunglass\",\"level\":\"1\",\"position\":3,\"parent_id\":\"6\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:23:37\",\"updated_at\":\"2020-01-11 07:17:28\",\"_153338052644\":[{\"id\":10,\"collection_id\":\"56378818596\",\"collection_name\":\"Brand Logos\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"brand_logo\",\"tags\":\"CT_mynta,CT_flipkart,CT_amazon\",\"level\":\"2\",\"position\":5,\"parent_id\":\"8\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/e5d5dd05841489a766156c845cb90d55d6dafe10.jpg?v=1565096672\",\"created_at\":\"2020-01-10 09:24:34\",\"updated_at\":\"2020-01-10 09:24:34\",\"_56378818596\":[{\"id\":13,\"collection_id\":\"153338150948\",\"collection_name\":\"Smart Collections\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"smart_collection\",\"tags\":\"CT_mobiles\",\"level\":\"3\",\"position\":6,\"parent_id\":\"10\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/6a218568284d308d904269176416f98fd9a901c9.jpg?v=1572934245\",\"created_at\":\"2020-01-10 10:37:11\",\"updated_at\":\"2020-01-10 10:37:11\"},{\"id\":11,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"accessories_title\",\"tags\":\"CT_balls,CT_bearing\",\"level\":\"3\",\"position\":6,\"parent_id\":\"10\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:30:57\",\"updated_at\":\"2020-01-11 07:17:00\"}]}]}]},{\"id\":7,\"collection_id\":\"56379047972\",\"collection_name\":\"Dresses\",\"parent_collection_id\":\"56379047972\",\"shop_id\":24,\"title\":\"dress\",\"tags\":\"CT_levi's,CT_polo,CT_flyingmachine\",\"level\":\"0\",\"position\":1,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/Dresses.png?v=1565096902\",\"created_at\":\"2020-01-10 09:23:02\",\"updated_at\":\"2020-01-10 12:08:39\",\"_56379047972\":[{\"id\":9,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"dress_titles\",\"tags\":\"CT_long,CT_short\",\"level\":\"1\",\"position\":4,\"parent_id\":\"7\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:24:01\",\"updated_at\":\"2020-01-11 07:17:31\"}]},{\"id\":16,\"collection_id\":\"56379015204\",\"collection_name\":\"Clothes\",\"parent_collection_id\":\"56379015204\",\"shop_id\":24,\"title\":\"Cloths\",\"tags\":\"\",\"level\":\"0\",\"position\":7,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/clothes.jpg?v=1565096838\",\"created_at\":\"2020-01-11 07:16:19\",\"updated_at\":\"2020-01-11 07:16:19\"}]}";
 //   String jsonStringList = "{\"status\":1,\"msg\":\"\",\"is_custom_collection\":1,\"collection-list\":[{\"id\":6,\"collection_id\":\"56378982436\",\"collection_name\":\"Mobiles\",\"parent_collection_id\":\"56378982436\",\"shop_id\":24,\"title\":\"mobile_titles\",\"tags\":\"CT_realme,CT_samsung,CT_nokia\",\"level\":\"0\",\"position\":0,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/e5d5dd05841489a766156c845cb90d55d6dafe10_e2a315f5-9225-4209-bc0f-8510817b7bba.jpg?v=1565096757\",\"created_at\":\"2020-01-10 09:21:37\",\"updated_at\":\"2020-01-10 12:08:39\",\"_56378982436\":[{\"id\":8,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"mobile_accessories\",\"tags\":\"CT_cover,CT_charger,CT_tuffunglass\",\"level\":\"1\",\"position\":3,\"parent_id\":\"6\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:23:37\",\"updated_at\":\"2020-01-11 07:17:28\",\"_153338052644\":[{\"id\":10,\"collection_id\":\"56378818596\",\"collection_name\":\"Brand Logos\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"brand_logo\",\"tags\":\"CT_mynta,CT_flipkart,CT_amazon\",\"level\":\"2\",\"position\":5,\"parent_id\":\"8\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/e5d5dd05841489a766156c845cb90d55d6dafe10.jpg?v=1565096672\",\"created_at\":\"2020-01-10 09:24:34\",\"updated_at\":\"2020-01-10 09:24:34\",\"_56378818596\":[{\"id\":13,\"collection_id\":\"153338150948\",\"collection_name\":\"Smart Collections\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"smart_collection\",\"tags\":\"CT_mobiles\",\"level\":\"3\",\"position\":6,\"parent_id\":\"10\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/6a218568284d308d904269176416f98fd9a901c9.jpg?v=1572934245\",\"created_at\":\"2020-01-10 10:37:11\",\"updated_at\":\"2020-01-10 10:37:11\"},{\"id\":11,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"accessories_title\",\"tags\":\"CT_balls,CT_bearing\",\"level\":\"3\",\"position\":6,\"parent_id\":\"10\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:30:57\",\"updated_at\":\"2020-01-11 07:17:00\"}]}]}]},{\"id\":7,\"collection_id\":\"56379047972\",\"collection_name\":\"Dresses\",\"parent_collection_id\":\"56379047972\",\"shop_id\":24,\"title\":\"dress\",\"tags\":\"CT_levi's,CT_polo,CT_flyingmachine\",\"level\":\"0\",\"position\":1,\"parent_id\":\"0\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/Dresses.png?v=1565096902\",\"created_at\":\"2020-01-10 09:23:02\",\"updated_at\":\"2020-01-10 12:08:39\",\"_56379047972\":[{\"id\":9,\"collection_id\":\"153338052644\",\"collection_name\":\"ASC\",\"parent_collection_id\":\"\",\"shop_id\":24,\"title\":\"dress_titles\",\"tags\":\"CT_long,CT_short\",\"level\":\"1\",\"position\":4,\"parent_id\":\"7\",\"image\":\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/1824\\/8181\\/collections\\/images.png?v=1578726551\",\"created_at\":\"2020-01-10 09:24:01\",\"updated_at\":\"2020-01-11 07:17:31\"}]}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NLevelExpandableListView();

    }

    private void NLevelExpandableListView() {
        try {
            listView = (ListView) findViewById(R.id.listView1);
            list = new ArrayList<NLevelItem>();
            final LayoutInflater inflater = LayoutInflater.from(this);

            JSONObject jsonObject = new JSONObject(jsonStringList);
            if (jsonObject.toString().contains(Constant.JSON_KEY.STATUS)) {
                String status = jsonObject.getString(Constant.JSON_KEY.STATUS);
                if (status.equals("1")) {
                    try {
                        if (jsonObject.has("collection-list")) {
                            String WholeResponse = String.valueOf(jsonObject);
                            JSONArray ColelctionListJsonArray = jsonObject.getJSONArray("collection-list");
                            nestedLoop(ColelctionListJsonArray.toString(), null, inflater, 0);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(this, "no_collection_found", Toast.LENGTH_LONG).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    int childrenSize = 0;
    JSONArray jsonArray = new JSONArray();

    private void nestedLoop(String levelList, NLevelItem nLevelItem, final LayoutInflater inflater, int level) {
        try {
            JSONArray ColelctionListJsonArray = new JSONArray(levelList);
            for (int i = 0; i < ColelctionListJsonArray.length(); i++) {
                JSONObject jsonObjectCOllectionListData = ColelctionListJsonArray.getJSONObject(i);
                NLevelItem collection = new NLevelItem();
                collection.setId(jsonObjectCOllectionListData.getString("collection_id"));
                collection.setTitle(jsonObjectCOllectionListData.getString("collection_name"));
                collection.setImage(jsonObjectCOllectionListData.getString("image"));
                collection.setTag(jsonObjectCOllectionListData.getString("tags"));
                if (jsonObjectCOllectionListData.has("_" + jsonObjectCOllectionListData.getString("collection_id"))) {
                    jsonArray = jsonObjectCOllectionListData.getJSONArray("_" + jsonObjectCOllectionListData.getString("collection_id"));
                    collection.setWholeResponse(jsonArray.toString());
                    NLevelItem collection1 = new NLevelItem();
                    childrenSize = jsonArray.length();
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject jsonObjectCOllectionListDataJsonObject1 = ColelctionListJsonArray.getJSONObject(i);
                        collection1.setId(jsonObjectCOllectionListDataJsonObject1.getString("collection_id"));
                        collection1.setTitle(jsonObjectCOllectionListDataJsonObject1.getString("collection_name"));
                        collection1.setImage(jsonObjectCOllectionListDataJsonObject1.getString("image"));
                        collection1.setTag(jsonObjectCOllectionListDataJsonObject1.getString("tags"));
                        //list.add(collection1);
                    }
                } else {
                    collection.setWholeResponse(null);
                }

                NLevelItem Parent = itemView(i, jsonObjectCOllectionListData.getString("collection_name"), nLevelItem, inflater, level, !(childrenSize > 0));
                list.add(collection);

                if (childrenSize > 0) {
                    if (jsonObjectCOllectionListData.has("_" + jsonObjectCOllectionListData.getString("collection_id"))) {
                        nestedLoop(jsonObjectCOllectionListData.getJSONArray("_" + jsonObjectCOllectionListData.getString("collection_id")).toString(), Parent, inflater, level + 1);
                    }
                }
            }


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

//            JSONArray jsonArrayStringList = new JSONArray(levelList);
//            int length = jsonArrayStringList.length();
//            for (int i=0; i<length; i++){
//                JSONObject itemObject = jsonArrayStringList.getJSONObject(i);
//                int childrenSize = itemObject.getJSONArray("children").length();
//                NLevelItem Parent = itemView(i, itemObject.getString("title"), nLevelItem, inflater, level, !(childrenSize>0));
//                list.add(Parent);
//
//                if(childrenSize>0){
//                    nestedLoop(itemObject.getJSONArray("children").toString(), Parent, inflater, level+1);
//                }
//            }

        } catch (Exception e) {
        e.getStackTrace();
        }

    }

    private NLevelItem itemView(int itemRow, final String Title, NLevelItem nLevelItem, final LayoutInflater inflater, final int level, final boolean isLast) {

        NLevelItem superChild = new NLevelItem(new SomeObject(Title), nLevelItem, new NLevelView() {
            @Override
            public View getView(NLevelItem item) {
                View view = inflater.inflate(R.layout.list_item, null);
                TextView tv = (TextView) view.findViewById(R.id.textView);
                String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                tv.setText(name);

                tv.setBackgroundColor(colors[level]);

                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) tv.getLayoutParams();
                mlp.setMargins(level * 50, 5, 5, 5);

                if (isLast) {
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Clicked on: " + Title, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                return view;
            }
        });

        return superChild;
    }

}
