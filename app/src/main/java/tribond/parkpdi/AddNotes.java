package tribond.parkpdi;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import tribond.parkpdi.adapter.NotesAdapter;
import tribond.parkpdi.pack.NoteDTO;
import tribond.parkpdi.util.CommonUtil;
import tribond.parkpdi.util.VerticalSpaceItemDecoration;


public class AddNotes extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView notes;
    private ArrayList<NoteDTO> noteList;
    private TextView msg;
    private Dialog dialog;
    private NotesAdapter notesAdapter;
    private Button apply, cancel;
    private EditText title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(AddNotes.this);
                Window window = dialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
                wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                wlp.gravity = Gravity.BOTTOM;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(wlp);
                dialog.setContentView(R.layout.dialog_add_notes);
                dialog.show();

                title = (EditText) dialog.findViewById(R.id.tv_title);
                description = (EditText) dialog.findViewById(R.id.tv_description);
                cancel = (Button) dialog.findViewById(R.id.btn_cancel);
                apply = (Button) dialog.findViewById(R.id.btn_apply);
                cancel.setOnClickListener(AddNotes.this);
                apply.setOnClickListener(AddNotes.this);

            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initialize();
    }

    private void initialize() {
        notes = (RecyclerView) findViewById(R.id.rec_notes);
        msg = (TextView) findViewById(R.id.tv_msg);
        notes.addItemDecoration(new VerticalSpaceItemDecoration(this));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        notes.setLayoutManager(mLayoutManager);
        noteList = new ArrayList<>();
        notesAdapter = new NotesAdapter(this, noteList);
        notes.setAdapter(notesAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apply:
                if (title.getText().toString().length() == 0) {
                    CommonUtil.showOkDialog(this, "Alert", "Please enter notes title");
                    return;
                }
                if (title.getText().toString().length() == 0) {
                    CommonUtil.showOkDialog(this, "Alert", "Please enter notes description");
                    return;
                }
                NoteDTO noteDTO = new NoteDTO();
                noteDTO.setTitle(title.getText().toString());
                noteDTO.setNotes(description.getText().toString());
                noteList.add(noteDTO);
                notesAdapter.notifyDataSetChanged();
                dialog.cancel();
                break;
            case R.id.btn_cancel:
                dialog.cancel();
                break;

        }
    }
}
