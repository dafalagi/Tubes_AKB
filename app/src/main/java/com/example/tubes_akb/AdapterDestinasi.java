
// Dafa Rizky Fahreza
// 10119113
// IF-3

package com.example.tubes_akb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDestinasi{
    private Context nContext;
    private wisataAdapter nWisataAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<ListMaps> listMaps,
                          List<String> keys){
        nContext = context;
        nWisataAdapter = new wisataAdapter(listMaps, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(nWisataAdapter);
    }

    class wisataItemView extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView desc;
        private TextView lat;
        private TextView lng;
        private String key;

        public wisataItemView(ViewGroup parent){
            super(LayoutInflater.from(nContext).
                    inflate(R.layout.fragment_home, parent, false));

            title = (TextView) itemView.findViewById(R.id.ListTitle);
            desc = (TextView) itemView.findViewById(R.id.ListDescription);
        }

        public void bind(ListMaps listMap, String key){
            title.setText(listMap.getTitle());
            desc.setText(listMap.getDesc());
        }
    }

    class wisataAdapter extends RecyclerView.Adapter<wisataItemView>{
        private List<ListMaps> listMaps;
        private List<String> keys;

        public wisataAdapter(List<ListMaps> listMaps, List<String> keys) {
            this.listMaps = listMaps;
            this.keys = keys;
        }

        @NonNull
        @Override
        public wisataItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new wisataItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull wisataItemView holder, int position) {
            holder.bind(listMaps.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return listMaps.size();
        }
    }
}
