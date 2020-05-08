package com.anhttvn.customrecyclerview.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.anhttvn.customrecyclerview.AnimalActivity;
import com.anhttvn.customrecyclerview.R;
import com.anhttvn.customrecyclerview.model.ItemAdapter;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemAdapter> mList;
    private Context mContext;
    private String[] name = {
            "Lion",
            "Elephant",
            "Cheetah",
            "Giraffe",
            "Tiger"
    };
    private String[] information = {"The lion is a species in the family Felidae; it is a muscular, deep-chested cat with a short, rounded head, a reduced neck and round ears, and a hairy tuft at the end of its tail."
            , "Elephants are mammals of the family Elephantidae and the largest existing land animals. Three species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant.",
            "The cheetah is a large cat of the subfamily Felinae that occurs in North, Southern and East Africa, and a few localities in Iran. It inhabits a variety of mostly arid habitats like dry forests, scrub forests, and savannahs.",
            "The giraffe is an African artiodactyl mammal, the tallest living terrestrial animal and the largest ruminant. It is traditionally considered to be one species, Giraffa camelopardalis, with nine subspecies. ",
            "The tiger is the largest species among the Felidae and classified in the genus Panthera. It is most recognisable for its dark vertical stripes on orangish-brown fur with a lighter underside. " };
    private int[] images = {R.drawable.lion, R.drawable.elephant, R.drawable.cheetah,
    R.drawable.giraffe, R.drawable.tiger};


    public ListAdapter(List<ItemAdapter> list, Context context){
        super();
        mList = list;
        mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_custom, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {
        ItemAdapter itemAdapter = mList.get(position);
        ((ViewHolder) viewHolder).Text.setText(itemAdapter.getText());
        ((ViewHolder) viewHolder).Img.setImageResource(itemAdapter.getImage());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final int pos = viewHolder.getAdapterPosition();
                final Intent i = new Intent(view.getContext(), AnimalActivity.class);
                if(pos == (getItemCount() - 1)){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                    builder1.setTitle("Danger Alert");
                    builder1.setMessage("This animal is dangerous, want to proceed?");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    i.putExtra("name1", name[pos]);
                                    i.putExtra("info", information[pos]);
                                    i.putExtra("Image1", images[pos]);
                                    view.getContext().startActivity(i);
                                }
                            });
                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else {
                    i.putExtra("name1", name[pos]);
                    i.putExtra("info", information[pos]);
                    i.putExtra("Image1", images[pos]);
                    view.getContext().startActivity(i);
                }
            }
        });


    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Text;
        public ImageView Img;
        public ViewHolder(View itemView) {

            super(itemView);
            Text = (TextView) itemView.findViewById(R.id.tv_name);
            Img = (ImageView) itemView.findViewById(R.id.img_item);

        }
    }


}
