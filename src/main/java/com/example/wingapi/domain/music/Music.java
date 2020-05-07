package com.example.wingapi.domain.music;

import com.example.wingapi.domain.album.Album;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicId;

    private String musicName;
    private String musicGenre;
    private String fileUri;
    private int trackNumber;
    private String lyrics;

    @Column
    @ColumnDefault("0")
    private Long likeCnt;

    @ManyToOne(targetEntity = Album.class, fetch = FetchType.EAGER)
    @JoinColumn(name="album_id")
    private Album toAlbum;


    @OneToMany(mappedBy = "music", cascade = CascadeType.ALL)
    List<MusicInfo> infos = new ArrayList<>();


    @Builder
    public Music(String musicName, String musicGenre, String fileUri,
                 int trackNumber, String lyrics, Album toAlbum) {

        this.musicName = musicName;
        this.musicGenre = musicGenre;
        this.fileUri = fileUri;
        this.trackNumber = trackNumber;
        this.lyrics = lyrics;
        this.toAlbum = toAlbum;
        this.likeCnt = 0L;
    }

    public void update(String musicName, String musicGenre, String fileUri,
                       int trackNumber, String lyrics) {

        this.musicName = musicName;
        this.musicGenre = musicGenre;
        this.fileUri = fileUri;
        this.trackNumber = trackNumber;
        this.lyrics = lyrics;
    }
}
