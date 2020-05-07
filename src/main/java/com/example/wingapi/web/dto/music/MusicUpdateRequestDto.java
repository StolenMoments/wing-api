package com.example.wingapi.web.dto.music;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MusicUpdateRequestDto {

    private String musicName;
    private String musicGenre;
    private String fileUri;
    private int trackNumber;
    private String lyrics;

    @Builder
    public MusicUpdateRequestDto(String musicName, String musicGenre, String fileUri,
                                 int trackNumber, String lyrics) {

        this.musicName = musicName;
        this.musicGenre = musicGenre;
        this.fileUri = fileUri;
        this.trackNumber = trackNumber;
        this.lyrics = lyrics;
    }
}
