package tribond.parkpdi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tribond.parkpdi.R;
import tribond.parkpdi.pack.NoteDTO;

/**
 * Created by sandeepjoshi on 10/08/16.
 */
public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<NoteDTO> notes;
    private Context context;

    public NotesAdapter(Context context, ArrayList<NoteDTO> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notes_item, null, false);
        NotesHolder notesHolder = new NotesHolder(v);
        return notesHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NotesHolder) holder).description.setText(notes.get(position).getNotes());
        ((NotesHolder) holder).title.setText(notes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    class NotesHolder extends RecyclerView.ViewHolder {

        public TextView title, description;

        public NotesHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }
}
