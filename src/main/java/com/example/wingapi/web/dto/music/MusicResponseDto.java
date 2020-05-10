package com.example.wingapi.web.dto.music;

import com.example.wingapi.domain.music.Music;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import lombok.Getter;

import java.util.*;

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
    private final Set<Map<String, String>> artistList;

    public MusicResponseDto(Music entity) {
        this.musicId = entity.getMusicId();
        this.musicName = entity.getMusicName();
        this.musicGenre = entity.getMusicGenre();
        this.fileUri = entity.getFileUri();
        this.trackNumber = entity.getTrackNumber();
        this.lyrics = entity.getLyrics();
        this.likeCnt = entity.getLikeCnt();
        this.albumId = entity.getToAlbum().getAlbumId();

        this.artistList = new HashSet<>();
        for(MusicInfo info : entity.getInfos()) {
            Map<String, String> artistObj = new HashMap<>();
            artistObj.put("artistId", info.getArtist().getArtistId().toString());
            artistObj.put("artistName", info.getArtist().getArtistName());
            artistList.add(artistObj);
        }
    }
}
