package tribond.parkpdi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tribond.parkpdi.R;
import tribond.parkpdi.holder.CheckListHolder;
import tribond.parkpdi.holder.LodgeHeaderHolder;

/**
 * Created by sandeepjoshi on 08/08/16.
 */
public class CheckListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public CheckListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.park_detail_header, parent, false);
            LodgeHeaderHolder checkListHolder = new LodgeHeaderHolder(view);
            return checkListHolder;
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.checklist_header, null, false);
            CheckListHolder checkListHolder = new CheckListHolder(view);
            return checkListHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.check_list_item, null);
            CheckListHolder checkListHolder = new CheckListHolder(view);
            return checkListHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
