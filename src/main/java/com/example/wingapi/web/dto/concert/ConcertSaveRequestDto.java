package com.example.wingapi.web.dto.concert;

import com.example.wingapi.domain.concert.Concert;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ConcertSaveRequestDto {

    private String concertName;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String tickekUri;
    private String place;
    private String imageUri;
    private String description;

    @Builder
    public ConcertSaveRequestDto(String concertName, LocalDateTime dateStart, LocalDateTime dateEnd,
                                 String tickekUri, String place, String imageUri, String description) {
        this.concertName = concertName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tickekUri = tickekUri;
        this.place = place;
        this.imageUri = imageUri;
        this.description = description;
    }

    public Concert toEntity() {
        return Concert.builder()
                .concertName(concertName)
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .tickekUri(tickekUri)
                .place(place)
                .imageUri(imageUri)
                .description(description)
                .build();
    }
}
