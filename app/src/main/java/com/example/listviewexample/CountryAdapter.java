package com.example.listviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    Context ctx;
    String ctry, cptl;
    int flg;
    List<Country> countryList;
    View rowLayout;
    RecyclerView.ViewHolder viewHolder;
    int pos = 0;


    public CountryAdapter(Context context, List<Country> countryArrayList) {
        ctx = context;
        countryList = countryArrayList;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create ViewHolder Object
        View rowLayout = layoutInflater.inflate(R.layout.row_country, parent, false);
        ViewHolder holder = new ViewHolder(rowLayout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        // Bind the data to the views present in ViewHolder
        Country country = countryList.get(position);
        String ctryName = country.getCountryName();
        String cptlName = country.getCapitalName();
        int ctryFlag = country.getFlagId();

        holder.tvCountry.setText(ctryName);
        holder.tvCapital.setText(cptlName);
        holder.imgViewFlag.setImageResource(ctryFlag);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewFlag;
        TextView tvCountry, tvCapital;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountry = itemView.findViewById(R.id.countryName);
            tvCapital = itemView.findViewById(R.id.capitalName);
            imgViewFlag = itemView.findViewById(R.id.countryFlag);
        }
    }

    /* @Override
     public int getCount() {
         return countryList.size();
     }

     @Override
     public Object getItem(int i) {
         return null;
     }

     @Override
     public long getItemId(int i) {
         return 0;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup viewGroup) {
         if (convertView == null) {
             convertView = layoutInflater.inflate(R.layout.row_country, null);
             viewHolder = new ViewHolder();
             viewHolder.tvCountry = convertView.findViewById(R.id.countryName);
             viewHolder.tvCapital = convertView.findViewById(R.id.capitalName);
             viewHolder.imgViewFlag = convertView.findViewById(R.id.countryFlag);
             convertView.setTag(viewHolder);
         } else {
             viewHolder = (ViewHolder) convertView.getTag();
         }

         Country country = countryList.get(position);

         ctry = country.getCountryName();
         cptl = country.getCapitalName();
         flg = country.getFlagId();


         viewHolder.tvCountry.setText(ctry);
         viewHolder.tvCapital.setText(cptl);
         viewHolder.imgViewFlag.setImageResource(flg);


         return convertView;
     }
 */
   /* public static class ViewHolder {
        ImageView imgViewFlag;
        TextView tvCountry, tvCapital;
    }*/
}
