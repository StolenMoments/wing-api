package com.example.wingapi.web.dto;

import com.example.wingapi.domain.artist.Artist;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Getter
public class ArtistSaveRequestDto {

    private String artistName;
    private String artistCompany;
    private String artistGenre;
    private Date debutDate;
    private String imageUri;
    private String description;
    private String realName;
    private String account;
    private String bank;

    @Builder
    public ArtistSaveRequestDto(String artistName, String artistCompany, String artistGenre, Date debutDate, String imageUri, String description, String realName, String account, String bank) {
        this.artistName = artistName;
        this.artistCompany = artistCompany;
        this.artistGenre = artistGenre;
        this.debutDate = debutDate;
        this.imageUri = imageUri;
        this.description = description;
        this.realName = realName;
        this.account = account;
        this.bank = bank;
    }

    public Artist toEntity() {
        return Artist.builder()
                .artistName(artistName)
                .artistCompany(artistCompany)
                .artistGenre(artistGenre)
                .debutDate(debutDate)
                .imageUri(imageUri)
                .description(description)
                .realName(realName)
                .account(account)
                .bank(bank)
                .build();
    }
}
