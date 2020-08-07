package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {
    private Context context;
    private RecOnClickListener recOnClickListener;
    private List<ListItem> listItemsArray;


    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_layout ,parent, false);
        return new DataHolder(view);
    }

    public DataAdapter(Context context, RecOnClickListener recOnClickListener, List<ListItem> listItemsArray) {
        this.context = context;
        this.recOnClickListener = recOnClickListener;
        this.listItemsArray = listItemsArray;
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.setData(listItemsArray.get(position));

    }

    @Override
    public int getItemCount() {
        return listItemsArray.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvText;
        private ImageButton imageButtonFav;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tw2);
//            imageButtonFav = itemView.findViewById(R.id.imBat);
//            itemView.setOnClickListener(this);
        }
        public void setData(ListItem item){
            tvText.setText(item.getText());

        }

        @Override
        public void onClick(View view) {
            recOnClickListener.onItemCliked(getAdapterPosition());

        }
    }
}
