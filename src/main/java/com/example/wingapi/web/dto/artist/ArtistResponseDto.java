package com.example.wingapi.web.dto.artist;

import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ArtistResponseDto {

    private final Long artistId;
    private final String artistName;
    private final String artistCompany;
    private final String artistGenre;
    private final Date debutDate;
    private final String video;
    private final String imageUri;
    private final String description;
    private final String realName;
    private final String account;
    private final String bank;
    private final Set<Long> albumIdList;
    private final List<Long> musicIdList;

    public ArtistResponseDto(Artist entity) {
        this.artistId = entity.getArtistId();
        this.artistName = entity.getArtistName();
        this.artistCompany = entity.getArtistCompany();
        this.artistGenre = entity.getArtistGenre();
        this.debutDate = entity.getDebutDate();
        this.video = entity.getVideo();
        this.imageUri = entity.getImageUri();
        this.description = entity.getDescription();
        this.realName = entity.getRealName();
        this.account = entity.getAccount();
        this.bank = entity.getBank();

        this.albumIdList = new HashSet<>();
        this.musicIdList = new ArrayList<>();
        for(MusicInfo info : entity.getInfos()) {
            albumIdList.add(info.getAlbum().getAlbumId());
            musicIdList.add(info.getMusic().getMusicId());
        }

    }
}
