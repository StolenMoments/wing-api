package com.example.wingapi.service;

import com.example.wingapi.domain.album.Album;
import com.example.wingapi.domain.album.AlbumRepository;
import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.artist.ArtistRepository;
import com.example.wingapi.domain.music.Music;
import com.example.wingapi.domain.music.MusicRepository;
import com.example.wingapi.domain.musicInfo.MusicInfoRepository;
import com.example.wingapi.web.dto.music.MusicResponseDto;
import com.example.wingapi.web.dto.music.MusicSaveRequestDto;
import com.example.wingapi.web.dto.music.MusicUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicInfoService musicInfoService;
    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final MusicInfoRepository musicInfoRepository;

    @Transactional
    public Long save(Long artistId, Long albumId, MusicSaveRequestDto requestDto) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(
                () -> new IllegalArgumentException("해당 아티스트 없음 id=" + artistId)
        );

        Album toAlbum = albumRepository.findById(albumId).orElseThrow(
                () -> new IllegalArgumentException("해당 앨범 없음 id=" + albumId)
        );

        Music music = musicRepository.save(requestDto.toEntity(toAlbum));


        musicInfoService.save(artist, toAlbum, music);

        return music.getMusicId();
    }

    @Transactional
    public Long update(Long id, MusicUpdateRequestDto requestDto) {
        Music music = musicRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("음악 정보 없음 id=" + id));

        music.update(requestDto.getMusicName(), requestDto.getMusicGenre(), requestDto.getFileUri()
                , requestDto.getTrackNumber(), requestDto.getLyrics());

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Music music = musicRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("음악 정보 없음 id=" + id));

        musicRepository.delete(music);

        return id;
    }

    public MusicResponseDto findById(Long id) {
        Music music = musicRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("음악 정보 없음 id=" + id));

        return new MusicResponseDto(music);
    }

    public List<MusicResponseDto> findByNameContaining(String name) {
        List<Music> musicList = musicRepository.findByMusicNameContaining(name);
        List<MusicResponseDto> responseDtos = new ArrayList<>();

        for (Music music : musicList)
            responseDtos.add(new MusicResponseDto(music));

        return responseDtos;
    }
}
