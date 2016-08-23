package tribond.parkpdi.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import tribond.parkpdi.R;
import tribond.parkpdi.pack.AudioDTO;


/**
 * Created by sandeepjoshi on 09/08/16.
 */
public class AudioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private Context context;
    private ArrayList<AudioDTO> audios;
    private MediaPlayer mPlayer;
    private String audioSource;
    private ImageView playImage;

    public AudioAdapter(Context context, ArrayList<AudioDTO> audios) {
        this.audios = audios;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.audio_item, null);
        AudioHolder audioHolder = new AudioHolder(v);
        return audioHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AudioHolder audioHolder = (AudioHolder) holder;
        audioHolder.title.setText(audios.get(position).getTitle());
        audioHolder.speaker.setTag(audios.get(position).getFilePath());
        audioHolder.speaker.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return audios.size();
    }

    @Override
    public void onClick(View view) {
        onPlay(view, (String) view.getTag());


    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (playImage != null) {
            playImage.setImageResource(R.drawable.play_btn);
        }
    }

    public void onPlay(View vi, String fileName) {
        if (mPlayer != null) {
            if (fileName.equals(audioSource)) {
                playImage.setImageResource(R.drawable.play_btn);
                stopPlaying(null);
            } else {
                playImage.setImageResource(R.drawable.play_btn);
                playImage = (ImageView) vi;
                stopPlaying(fileName);
            }
        } else {
            playImage = (ImageView) vi;
            startPlaying(fileName);
        }

    }

    public void startPlaying(String fileName) {
        mPlayer = new MediaPlayer();
        audioSource = fileName;
        try {
            mPlayer.setDataSource(fileName);
            mPlayer.prepare();
            mPlayer.start();
            playImage.setImageResource(R.drawable.stop_btn);
            mPlayer.setOnCompletionListener(this);
        } catch (IOException e) {
            Log.e("LOG_TAG", "prepare() failed");
        }
    }

    public void stopPlaying(String fileName) {
        playImage.setImageResource(R.drawable.play_btn);
        mPlayer.stop();
        mPlayer.reset();
        mPlayer.release();

        audioSource = fileName;
        mPlayer = null;
        if (fileName != null) {
            startPlaying(fileName);
        }
    }

    class AudioHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView speaker;

        public AudioHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            speaker = (ImageView) itemView.findViewById(R.id.iv_speaker);
        }
    }
}
