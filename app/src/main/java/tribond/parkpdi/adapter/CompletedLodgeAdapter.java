package tribond.parkpdi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tribond.parkpdi.R;
import tribond.parkpdi.holder.CompletedLodgeHolder;

/**
 * Created by sandeepjoshi on 10/08/16.
 */
public class CompletedLodgeAdapter extends RecyclerView.Adapter<CompletedLodgeHolder> {


    private Context context;

    public CompletedLodgeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CompletedLodgeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_completed_lodge, null, false);
        CompletedLodgeHolder completedLodgeHolder = new CompletedLodgeHolder(v);
        return completedLodgeHolder;
    }

    @Override
    public void onBindViewHolder(CompletedLodgeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
