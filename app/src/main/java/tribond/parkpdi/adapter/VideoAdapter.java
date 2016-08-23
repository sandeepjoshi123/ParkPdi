package tribond.parkpdi.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import tribond.parkpdi.R;
import tribond.parkpdi.pack.VideoDTO;

/**
 * Created by sandeepjoshi on 10/08/16.
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static String[] thumbColumns = {MediaStore.Video.Thumbnails.DATA};
    public static String[] mediaColumns = {MediaStore.Video.Media._ID};
    ArrayList<VideoDTO> videoDTOs;
    private Context context;

    public VideoAdapter(Context context, ArrayList<VideoDTO> videoDTOs) {
        this.context = context;
        this.videoDTOs = videoDTOs;
    }

    public static String getThumbnailPathForLocalFile(Activity context,
                                                      Uri fileUri) {

        long fileId = getFileId(context, fileUri);

        MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(),
                fileId, MediaStore.Video.Thumbnails.MINI_KIND, null);

        Cursor thumbCursor = null;
        try {

            thumbCursor = context.getContentResolver().query(
                    MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                    thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID + " = "
                            + fileId, null, null);

            if (thumbCursor.moveToFirst()) {
                String thumbPath = thumbCursor.getString(thumbCursor
                        .getColumnIndex(MediaStore.Video.Thumbnails.DATA));

                return thumbPath;
            }

        } finally {
        }

        return null;
    }

    public static long getFileId(Activity context, Uri fileUri) {

        try {


            Cursor cursor = context.getContentResolver().query(fileUri, mediaColumns, null, null,
                    null);

            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media._ID);
                int id = cursor.getInt(columnIndex);

                return id;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.video_item, null, false);
        VideoHolder videoHolder = new VideoHolder(v);
        return videoHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoHolder) holder).title.setText(videoDTOs.get(position).getTitle());


        if (videoDTOs.get(position).getThumbnail() == null) {
            videoDTOs.get(position).setThumbnail(getThumbnailPathForLocalFile((Activity) context, videoDTOs.get(position).getVideoUri()));
        }

        if (videoDTOs.get(position).getThumbnail() != null) {
            Picasso.with(context).load(new File(videoDTOs.get(position).getThumbnail())).
                    placeholder(R.drawable.add_video)
                    .resize(500, 500)
                    .centerInside()
                    .into(((VideoHolder) holder).thumb);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return videoDTOs.size();
    }

    class VideoHolder extends RecyclerView.ViewHolder {

        private ImageView thumb;
        private TextView title;

        public VideoHolder(View itemView) {
            super(itemView);
            thumb = (ImageView) itemView.findViewById(R.id.iv_video);
            title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
