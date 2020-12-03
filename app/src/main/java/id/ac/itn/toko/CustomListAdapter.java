package id.ac.itn.toko;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Toko> movieItems;

    public CustomListAdapter(Activity activity, List<Toko> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView buka = (TextView) convertView.findViewById(R.id.text_buka);
        TextView tutup = (TextView) convertView.findViewById(R.id.text_tutup);

        Toko t = movieItems.get(position);
        nama.setText("Nama Toko : "+ t.get_nama());
        buka.setText("Buka              : "+ t.get_buka());
        tutup.setText("Tutup            : "+ t.get_tutup());
        return convertView;
    }
}

