package com.example.wingapi.service;

import com.example.wingapi.domain.album.Album;
import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.music.Music;
import com.example.wingapi.domain.musicInfo.MusicInfo;
import com.example.wingapi.domain.musicInfo.MusicInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MusicInfoService {

    private final MusicInfoRepository musicInfoRepository;

    @Transactional
    public void save(Artist artist, Album album, Music music) {

        MusicInfo musicInfo = musicInfoRepository.save(MusicInfo.builder()
                .artist(artist)
                .album(album)
                .music(music)
                .build()
        );

        artist.getInfos().add(musicInfo);
        album.getInfos().add(musicInfo);
        music.getInfos().add(musicInfo);

        album.getMusicList().add(music);
    }
}
