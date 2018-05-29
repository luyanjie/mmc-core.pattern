package com.maochong.xiaojun.services1;

/**
 * @author jokin
 * @date 2018/5/29 16:03
 * 适配器接口（中间转换）
 */
public class MediaAdapter implements IMp3MediaPlayer {
    IAdvancedMediaPlay advancedMediaPlay;
    public MediaAdapter(){
        advancedMediaPlay = new AdvancedMediaPlay();
    }

    @Override
    public void playMp3(String audioType, String fileName) {
        if("mp4".equals(audioType)){
            advancedMediaPlay.playMp4(fileName);
        }
        else if("vlc".equals(audioType)){
            advancedMediaPlay.playVlc(fileName);
        }
        else {
            System.out.println("未找到指定播放格式！");
        }
    }
}
