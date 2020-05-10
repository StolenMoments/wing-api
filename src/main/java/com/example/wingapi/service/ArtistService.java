package com.example.wingapi.service;

import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.artist.ArtistRepository;
import com.example.wingapi.web.dto.artist.ArtistResponseDto;
import com.example.wingapi.web.dto.artist.ArtistSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public IllegalArgumentException exception(Long id) {
        return new IllegalArgumentException("아티스트 정보 없음" + id);
    }


    @Transactional
    public Long save(ArtistSaveRequestDto requestDto) {
        return artistRepository.save(requestDto.toEntity()).getArtistId();
    }


    // 쿼리를 안날리는 이유 : 더티 체킹 (https://jojoldu.tistory.com/415)
    @Transactional
    public Long update(Long id, ArtistSaveRequestDto requestDto) {
        Artist artist = artistRepository.findById(id).orElseThrow(
                () -> exception(id));

        artist.update(requestDto.getArtistName(), requestDto.getArtistCompany(),
                requestDto.getArtistGenre(), requestDto.getDebutDate(), requestDto.getVideo(),
                requestDto.getImageUri(), requestDto.getDescription(), requestDto.getRealName(),
                requestDto.getAccount(), requestDto.getBank());

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Artist entity = artistRepository.findById(id).orElseThrow(
                () -> exception(id));

        artistRepository.delete(entity);

        return id;
    }

    public ArtistResponseDto findById(Long id) {
        Artist entity = artistRepository.findById(id).orElseThrow(
                () -> exception(id));

        return new ArtistResponseDto(entity);
    }

    public List<ArtistResponseDto> findByNameContaining(String name) {
        List<Artist> artists = artistRepository.findByArtistNameContaining(name);
        List<ArtistResponseDto> responseDtos = new ArrayList<>();

        for (Artist artist : artists) responseDtos.add(new ArtistResponseDto(artist));
        return responseDtos;
    }

}
