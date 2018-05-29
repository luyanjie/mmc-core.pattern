package com.maochong.xiaojun.services1;

/**
 * @author jokin
 * @date 2018/5/29 16:06
 */
public class AdvancedMediaPlay implements IAdvancedMediaPlay {
    @Override
    public void playMp4(String fileName) {
        System.out.println("mp4:"+fileName);
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("vlc:"+fileName);
    }
}
