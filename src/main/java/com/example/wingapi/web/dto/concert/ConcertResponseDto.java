package com.example.wingapi.web.dto.concert;

import com.example.wingapi.domain.concert.Concert;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ConcertResponseDto {

    private final Long concertId;
    private final String concertName;
    private final LocalDateTime dateStart;
    private final LocalDateTime dateEnd;
    private final String tickekUri;
    private final String place;
    private final String imageUri;
    private final String description;
//    private final Set<Map<String, String>> artistList;

    public ConcertResponseDto(Concert entity) {
        this.concertId = entity.getConcertId();
        this.concertName = entity.getConcertName();
        this.dateStart = entity.getDateStart();
        this.dateEnd = entity.getDateEnd();
        this.tickekUri = entity.getTickekUri();
        this.place = entity.getPlace();
        this.imageUri = entity.getImageUri();
        this.description = entity.getDescription();

//        this.artistList = new HashSet<>();
//        for(Artist artist : entity.getArtistsList()) {
//            Map<String, String> artistObj = new HashMap<>();
//            artistObj.put("artistId", artist.getArtistId().toString());
//            artistObj.put("artistName", artist.getArtistName());
//            artistList.add(artistObj);
//        }
    }


}
