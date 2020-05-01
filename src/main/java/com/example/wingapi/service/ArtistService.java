package com.example.wingapi.service;

import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.artist.ArtistRepository;
import com.example.wingapi.web.dto.ArtistResponseDto;
import com.example.wingapi.web.dto.ArtistSaveRequestDto;
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

    @Transactional
    public Long save(ArtistSaveRequestDto requestDto) {
        return artistRepository.save(requestDto.toEntity()).getArtistId();
    }

    @Transactional
    public void delete(Long id) {
        Artist entity = artistRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not Found Data : id=" + id));
        artistRepository.delete(entity);
    }

    public ArtistResponseDto findById(Long id) {
        Artist entity = artistRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not Found Data : id=" + id));

        return new ArtistResponseDto(entity);
    }

    public List<ArtistResponseDto> findByNameContaining(String name) {
        List<Artist> artists = artistRepository.findByArtistNameContaining(name);
        List<ArtistResponseDto> responseDtos = new ArrayList<>();
        
        for (Artist artist : artists) responseDtos.add(new ArtistResponseDto(artist));
        return responseDtos;
    }

}
