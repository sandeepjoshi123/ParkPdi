package tribond.parkpdi;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import tribond.parkpdi.adapter.AudioAdapter;
import tribond.parkpdi.pack.AudioDTO;
import tribond.parkpdi.util.AudioRecorder;
import tribond.parkpdi.util.CommonUtil;
import tribond.parkpdi.util.VerticalSpaceItemDecoration;


public class AddAudio extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView rec_audio;
    private ArrayList<AudioDTO> audios;
    private EditText title;

    private Button record, stop, play, cancel, apply;
    private AudioRecorder audioRecorder;
    private boolean isRecording = false;
    private Dialog dialog;
    private AudioAdapter audioAdapter;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_audio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        msg = (TextView) findViewById(R.id.tv_msg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT < 23) {
                    recordAudio();
                } else {
                    if (checkSelfPermission(Manifest.permission.RECORD_AUDIO)
                            != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE
                                        , android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.RECORD_AUDIO},
                                1);
                    } else {
                        recordAudio();
                    }
                }


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
        audios = new ArrayList<>();
        rec_audio = (RecyclerView) findViewById(R.id.rec_audio);
        rec_audio.addItemDecoration(new VerticalSpaceItemDecoration(this));
        rec_audio.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rec_audio.setLayoutManager(mLayoutManager);
        audioAdapter = new AudioAdapter(this, audios);
        rec_audio.setAdapter(audioAdapter);
    }


    public void recordAudio() {
        audioRecorder = new AudioRecorder();

        dialog = new Dialog(this);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        dialog.setContentView(R.layout.dialog_add_audio);
        dialog.show();


        record = (Button) dialog.findViewById(R.id.btn_record);
        title = (EditText) dialog.findViewById(R.id.tv_title);

        stop = (Button) dialog.findViewById(R.id.btn_stop);
        play = (Button) dialog.findViewById(R.id.btn_playl);
        cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        apply = (Button) dialog.findViewById(R.id.btn_apply);
        record.setOnClickListener(this);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);
        cancel.setOnClickListener(this);
        apply.setOnClickListener(this);


        record.setEnabled(true);
        stop.setEnabled(false);
        play.setEnabled(false);
        apply.setEnabled(false);
        play.setAlpha(0.5f);
        stop.setAlpha(0.5f);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply:
                if (isRecording) {
                    return;
                }
                if (AudioRecorder.mFileName == null) {
                    return;
                }
                if (title.getText().toString().length() == 0) {
                    CommonUtil.showOkDialog(this, "Alert", "Please enter audio title");
                } else {

                    AudioDTO audioDTO = new AudioDTO();
                    audioDTO.setTitle(title.getText().toString());
                    audioDTO.setFilePath(AudioRecorder.mFileName);
                    audios.add(audioDTO);
                    dialog.dismiss();

                    // audioAdapter=new AudioAdapter(this,audios);
                    // rec_audio.setAdapter(audioAdapter);
                    audioAdapter.notifyDataSetChanged();
                    msg.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_cancel:
                if (audioRecorder != null && AudioRecorder.mFileName != null) {
                    File fil = new File(AudioRecorder.mFileName);
                    if (fil != null && fil.exists()) {
                        fil.delete();
                    }
                }
                dialog.dismiss();
                break;
            case R.id.btn_record:
                try {
                    audioRecorder.startRecording();
                    record.setSelected(true);
                    isRecording = true;
                    disableButton(stop);
                    if (play.isEnabled())
                        disableButton(play);
                    disableButton(record);
                    Toast.makeText(this, "Recording Started", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(rec_audio, "Unable to start recording. Audio source occupied by other process. Please restart your device.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                   /* }else {
                        CommonUtil.showOkDialog(this, "Alert", "Unable to start recording. Please restart your device and try again.");
                    }*/
                }
                break;
            case R.id.btn_stop:
                if (isRecording) {
                    isRecording = false;
                    audioRecorder.stopRecording();
                }
                record.setSelected(false);
                record.setText("Re-Record");
                disableButton(play);
                disableButton(stop);
                disableButton(record);
                apply.setEnabled(true);
                break;
            case R.id.btn_playl:
                if (audioRecorder.mPlayer != null && audioRecorder.mPlayer.isPlaying()) {
                    audioRecorder.stopPlaying();
                    record.setSelected(true);
                    play.setText("play Back");
                } else {
                    audioRecorder.startPlaying();
                    play.setText("Pause");
                }

                if (audioRecorder.mPlayer != null) {
                    audioRecorder.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            audioRecorder.mPlayer = null;
                            play.setText("play Back");
                        }
                    });
                }
                break;
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                recordAudio();
            } else {
                Snackbar.make(rec_audio, "You don't have permission of external storage.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
    }


    public void disableButton(Button btn) {
        if (btn.isEnabled()) {
            btn.setEnabled(false);
            btn.setAlpha(0.5f);
        } else {
            btn.setEnabled(true);
            btn.setAlpha(1.0f);
        }

    }


}
