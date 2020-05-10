package com.example.wingapi.web.dto.music;

import com.example.wingapi.domain.music.Music;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MusicResponseDto {

    private final Long musicId;
    private final String musicName;
    private final String musicGenre;
    private final String fileUri;
    private final int trackNumber;
    private final String lyrics;
    private final Long likeCnt;
    private final Long albumId;
    private final List<Long> artistIdList;

    public MusicResponseDto(Music entity) {
        this.musicId = entity.getMusicId();
        this.musicName = entity.getMusicName();
        this.musicGenre = entity.getMusicGenre();
        this.fileUri = entity.getFileUri();
        this.trackNumber = entity.getTrackNumber();
        this.lyrics = entity.getLyrics();
        this.likeCnt = entity.getLikeCnt();
        this.albumId = entity.getToAlbum().getAlbumId();

        this.artistIdList = new ArrayList<>();
        for(MusicInfo info : entity.getInfos())
            artistIdList.add(info.getArtist().getArtistId());

    }

}
