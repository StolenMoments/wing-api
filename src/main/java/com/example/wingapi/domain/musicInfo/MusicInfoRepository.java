package com.example.wingapi.domain.musicInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicInfoRepository extends JpaRepository<MusicInfo, Long> {

    List<MusicInfo> findByAlbum_AlbumId(Long id);
    List<MusicInfo> findByMusic_MusicId(Long id);

}
