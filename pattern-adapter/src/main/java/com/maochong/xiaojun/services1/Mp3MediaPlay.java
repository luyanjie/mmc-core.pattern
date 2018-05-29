package com.maochong.xiaojun.services1;

/**
 * @author jokin
 * @date 2018/5/29 15:53
 * Mp3播放实现类
 */
public class Mp3MediaPlay implements IMp3MediaPlayer {

    private MediaAdapter mediaAdapter = new MediaAdapter();

    @Override
    public void playMp3(String audioType, String fileName) {
        if("mp3".equals(audioType)){
            System.out.println("执行MP3 播放");
        }
        else {
            mediaAdapter.playMp3(audioType,fileName);
        }
    }
}
