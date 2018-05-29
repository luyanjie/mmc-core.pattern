package com.maochong.xiaojun.services1;

/**
 * @author jokin
 * @date 2018-05-29 16:20
 * 已播放器为例
 *
 * 适配器模式 简单来说就是，几个完全没有关联的接口实现，放在一个地方统一实现
 *
 */
public class AppService1
{
    public static void main( String[] args )
    {
        Mp3MediaPlay mp3MediaPlay = new Mp3MediaPlay();
        mp3MediaPlay.playMp3("mp3","mp3");
        mp3MediaPlay.playMp3("mp4","mp4");
        mp3MediaPlay.playMp3("vlc","vlc");
    }
}
