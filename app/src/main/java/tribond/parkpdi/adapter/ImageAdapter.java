package tribond.parkpdi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import tribond.parkpdi.R;


/**
 * Created by sandeepjoshi on 09/08/16.
 */
public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    ArrayList<String> images;
    private Context context;
    private ImageView main;

    public ImageAdapter(Context context, ArrayList<String> images, ImageView main) {
        this.context = context;
        this.images = images;
        this.main = main;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(context).inflate(R.layout.image_frame, parent, false);
        ImageHolder imageHolder = new ImageHolder(vi);
        return imageHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageHolder holder1 = (ImageHolder) holder;
        Picasso.with(context).load(new File(images.get(position))).
                placeholder(R.drawable.add_video)
                .resize(500, 500)
                .centerInside()
                .into(holder1.imageView);
        holder1.deleteBtn.setTag(position);
        holder1.deleteBtn.setOnClickListener(this);


        holder1.imageView.setTag(position);
        holder1.imageView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addImg:
                if (main != null)
                    Picasso.with(context).load(new File(images.get((int) view.getTag()))).
                            placeholder(R.drawable.add_video)
                            .resize(500, 500)
                            .centerInside()
                            .into(main);
                break;
            case R.id.deleteBtn:
                images.remove((int) view.getTag());
                this.notifyDataSetChanged();
                if (main != null) {
                    if (images.size() != 0) {
                        Picasso.with(context).load(new File(images.get(0))).
                                placeholder(R.drawable.add_video)
                                .resize(500, 500)
                                .centerInside()
                                .into(main);
                    } else {
                        main.setImageDrawable(null);
                    }
                }
                break;
        }
    }


    class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView, deleteBtn;

        public ImageHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.addImg);
            deleteBtn = (ImageView) itemView.findViewById(R.id.deleteBtn);
        }
    }
}
