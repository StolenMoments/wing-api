package com.example.wingapi.web.dto.music;

import com.example.wingapi.domain.album.Album;
import com.example.wingapi.domain.music.Music;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
public class MusicSaveRequestDto {

    private String musicName;
    private String musicGenre;
    private String fileUri;
    private int trackNumber;
    private String lyrics;
    private Set<Long> artistIdList;

    @Builder
    public MusicSaveRequestDto(String musicName, String musicGenre, String fileUri,
                               int trackNumber, String lyrics, Set<Long> artistIdList) {

        this.musicName = musicName;
        this.musicGenre = musicGenre;
        this.fileUri = fileUri;
        this.trackNumber = trackNumber;
        this.lyrics = lyrics;
        this.artistIdList = new HashSet<>(artistIdList);
    }


    public Music toEntity(Album toAlbum) {
        return Music.builder()
                .toAlbum(toAlbum)
                .trackNumber(trackNumber)
                .musicName(musicName)
                .musicGenre(musicGenre)
                .lyrics(lyrics)
                .fileUri(fileUri)
                .build();
    }


}
