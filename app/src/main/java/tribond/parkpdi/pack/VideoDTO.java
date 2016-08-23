package tribond.parkpdi.pack;

import android.net.Uri;

/**
 * Created by sandeepjoshi on 10/08/16.
 */
public class VideoDTO {

    private String title;
    private String thumbnail;
    private String imageUrl;
    private Uri videoUri;


    public Uri getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
