package com.example.wingapi.web.dto.album;

import com.example.wingapi.domain.album.Album;
import com.example.wingapi.domain.music.Music;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import lombok.Getter;

import java.sql.Date;
import java.util.*;

@Getter
public class AlbumResponseDto {

    private final Long albumId;
    private final String albumName;
    private final String albumGenre;
    private final String company;
    private final String distributor;
    private final Date date;
    private final String imageUri;
    private final String description;
    private final Set<Map<String, String>> musicList;
    private final Set<Map<String, String>> artistList;

    public AlbumResponseDto(Album entity) {
        this.albumId = entity.getAlbumId();
        this.albumName = entity.getAlbumName();
        this.albumGenre = entity.getAlbumGenre();
        this.company = entity.getCompany();
        this.distributor = entity.getDistributor();
        this.date = entity.getDate();
        this.imageUri = entity.getImageUri();
        this.description = entity.getDescription();

        this.musicList = new HashSet<>();
        for(Music music : entity.getMusicList()) {
            Map<String, String> musicObj = new HashMap<>();
            musicObj.put("musicId", music.getMusicId().toString());
            musicObj.put("musicName", music.getMusicName());
            musicObj.put("fileUri", music.getFileUri());
            musicObj.put("trackNumber", Integer.toString(music.getTrackNumber()));
            musicList.add(musicObj);
        }

        this.artistList = new HashSet<>();
        for (MusicInfo info : entity.getInfos()) {
            Map<String, String> artistObj = new HashMap<>();
            artistObj.put("artistId", info.getArtist().getArtistId().toString());
            artistObj.put("artistName", info.getArtist().getArtistName());
            artistList.add(artistObj);
        }
    }
}
