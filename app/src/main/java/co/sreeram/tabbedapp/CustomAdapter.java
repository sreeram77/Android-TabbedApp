package co.sreeram.tabbedapp;

/**
 * Created by Sreeram AN on 01/03/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    int [] type;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages, int[] flag) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        type=flag;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv,tv2;
        ImageView img;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        switch(type[position]) {
            case 1:
            holder.tv = (TextView) rowView.findViewById(R.id.textView1);
            holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
            holder.tv.setText(result[position]);
            holder.img.setImageResource(imageId[position]);
                break;
            case 2:
                holder.tv = (TextView) rowView.findViewById(R.id.textView1);
                holder.tv.setText(result[position]);
                break;
            case 3:
                holder.tv = (TextView) rowView.findViewById(R.id.textView1);
                holder.tv2 = (TextView) rowView.findViewById(R.id.textView2);
                holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
                holder.tv.setText(result[position]);
                holder.tv2.setText(result[position]);
                holder.img.setImageResource(imageId[position]);
                break;
        }
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
            }
        });
        return rowView;
    }

}