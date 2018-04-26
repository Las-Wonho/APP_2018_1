package com.laplace.las.fa;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    //Item 데이터를 저장할 리스트
    List<ListViewItem> listViewItemList = new ArrayList<>();

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void addItem(int imgId, String title, String desc){
        ListViewItem item=new ListViewItem();
        item.setImageID(imgId);
        item.setTitleStr(title);
        item.setDescStr(desc);

        listViewItemList.add(item);
    }

    @Override  //ListView에 화면에 뿌려질 Item을 제공한다.
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listview_item
                    , parent, false);
        }

        //현재 선택된 View에 연결되는 객체 생성
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
        TextView titleTextView=(TextView)convertView.findViewById(R.id.textView1);
        TextView descTextView=(TextView)convertView.findViewById(R.id.textView2);

        ListViewItem item=listViewItemList.get(position);

        //현재 선택된 View에 Data 삽입
        imageView.setImageResource(item.getImageID());
        titleTextView.setText(item.getTitleStr());
        descTextView.setText(item.getDescStr());

        return convertView;
    }
}
