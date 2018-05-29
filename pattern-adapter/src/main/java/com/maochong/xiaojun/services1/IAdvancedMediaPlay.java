package com.maochong.xiaojun.services1;

/**
 * @author jokin
 * @date 2018/5/29 15:54
 * 可以播放MP4 Vlc
 */
public interface IAdvancedMediaPlay {
    /**
     * 播放Mp4
     * */
    void playMp4(String fileName);

    /**
     * 播放Vlc
     * */
    void playVlc(String fileName);
}
