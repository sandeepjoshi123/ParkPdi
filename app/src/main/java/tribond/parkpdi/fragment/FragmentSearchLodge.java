package tribond.parkpdi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tribond.parkpdi.AddAudio;
import tribond.parkpdi.AddNotes;
import tribond.parkpdi.AddPhoto;
import tribond.parkpdi.AddVideo;
import tribond.parkpdi.R;
import tribond.parkpdi.adapter.CheckListAdapter;
import tribond.parkpdi.util.VerticalSpaceItemDecoration;

/**
 * Created by sandeepjoshi on 06/08/16.
 */
public class FragmentSearchLodge extends Fragment implements View.OnClickListener {

    private View root;
    private RecyclerView rec_park;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_search_lodge, container, false);
        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rec_park = (RecyclerView) view.findViewById(R.id.rec_park);
        rec_park.addItemDecoration(new VerticalSpaceItemDecoration(getActivity()));
        rec_park.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rec_park.setLayoutManager(mLayoutManager);

        view.findViewById(R.id.btn_add_audio).setOnClickListener(this);
        view.findViewById(R.id.btn_add_video).setOnClickListener(this);
        view.findViewById(R.id.btn_add_photo).setOnClickListener(this);
        view.findViewById(R.id.btn_add_Notes).setOnClickListener(this);


        rec_park.setAdapter(new CheckListAdapter(getActivity()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_audio:
                Intent intent = new Intent(getActivity(), AddAudio.class);
                startActivity(intent);
                break;
            case R.id.btn_add_photo:
                intent = new Intent(getActivity(), AddPhoto.class);
                startActivity(intent);
                break;
            case R.id.btn_add_video:
                intent = new Intent(getActivity(), AddVideo.class);
                startActivity(intent);
                break;
            case R.id.btn_add_Notes:
                intent = new Intent(getActivity(), AddNotes.class);
                startActivity(intent);
                break;
        }
    }
}
