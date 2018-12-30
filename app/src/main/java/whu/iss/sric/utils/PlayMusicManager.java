package whu.iss.sric.utils;

import android.content.Context;
import android.media.MediaPlayer;

public class PlayMusicManager {

    private static volatile PlayMusicManager mPlayMusicManager;

    private static MediaPlayer mMediaPlayer;

    public PlayMusicManager() {

    }

    public static PlayMusicManager getInstance() {
        if (mPlayMusicManager == null) {
            synchronized (PlayMusicManager.class) {
                if (mPlayMusicManager == null) {
                    mPlayMusicManager = new PlayMusicManager();
                }
            }
        }
        return mPlayMusicManager;
    }

    public void playMusic(Context context, int uri) {
        mMediaPlayer = MediaPlayer.create(context, uri);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                mMediaPlayer.start();
                mMediaPlayer.setLooping(true);
            }
        });
    }

    public void stopMusic() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
