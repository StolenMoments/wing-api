package com.example.wingapi.domain.artist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

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
    public Artist(Long artistId, String artistName, String artistCompany, String artistGenre, Date debutDate, String imageUri, String description, String realName, String account, String bank) {
        this.artistId = artistId;
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
}
