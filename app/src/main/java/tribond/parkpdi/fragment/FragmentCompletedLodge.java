package tribond.parkpdi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tribond.parkpdi.R;
import tribond.parkpdi.adapter.CompletedLodgeAdapter;
import tribond.parkpdi.util.VerticalSpaceItemDecoration;

/**
 * Created by sandeepjoshi on 10/08/16.
 */
public class FragmentCompletedLodge extends Fragment {
    private View root;
    private RecyclerView lodges;
    private CompletedLodgeAdapter completedLodgeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.content_add_notes, container, false);
        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lodges = (RecyclerView) view.findViewById(R.id.rec_notes);
        lodges.addItemDecoration(new VerticalSpaceItemDecoration(getActivity()));
        lodges.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        lodges.setLayoutManager(mLayoutManager);
        completedLodgeAdapter = new CompletedLodgeAdapter(getActivity());
        lodges.setAdapter(completedLodgeAdapter);
        ((TextView) view.findViewById(R.id.tv_msg)).setText("No data available");
    }
}
