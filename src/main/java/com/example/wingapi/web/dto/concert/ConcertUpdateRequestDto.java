package com.example.wingapi.web.dto.concert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ConcertUpdateRequestDto {

    private String concertName;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String tickekUri;
    private String place;
    private String imageUri;
    private String description;

    @Builder
    public ConcertUpdateRequestDto(String concertName, LocalDateTime dateStart, LocalDateTime dateEnd,
                                   String tickekUri, String place, String imageUri, String description) {
        this.concertName = concertName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tickekUri = tickekUri;
        this.place = place;
        this.imageUri = imageUri;
        this.description = description;
    }
}
