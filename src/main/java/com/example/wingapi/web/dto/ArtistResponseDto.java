package com.example.wingapi.web.dto;

import com.example.wingapi.domain.artist.Artist;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ArtistResponseDto {

    private final Long artistId;
    private final String artistCompany;
    private final String artistGenre;
    private final Date debutDate;
    private final String imageUri;
    private final String description;
    private final String realName;
    private final String account;
    private final String bank;

    public ArtistResponseDto(Artist entity) {
        this.artistId = entity.getArtistId();
        this.artistCompany = entity.getArtistCompany();
        this.artistGenre = entity.getArtistGenre();
        this.debutDate = entity.getDebutDate();
        this.imageUri = entity.getImageUri();
        this.description = entity.getDescription();
        this.realName = entity.getRealName();
        this.account = entity.getAccount();
        this.bank = entity.getBank();
    }
}
