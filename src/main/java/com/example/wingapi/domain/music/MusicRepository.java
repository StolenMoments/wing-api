package com.example.wingapi.domain.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    Set<Music> findByMusicNameContaining(String name);
}
