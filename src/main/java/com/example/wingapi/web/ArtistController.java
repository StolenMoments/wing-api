package com.example.wingapi.web;

import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.service.ArtistService;
import com.example.wingapi.web.dto.ArtistResponseDto;
import com.example.wingapi.web.dto.ArtistSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000" })
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/api/get/artist/{id}")
    private ArtistResponseDto findById(@PathVariable("id") Long id) {
        return artistService.findById(id);
    }

    @GetMapping("/api/get/artistFindByName/{name}")
    private List<ArtistResponseDto> findByName(@PathVariable("name") String name) {
        return artistService.findByNameContaining(name);
    }

    @PostMapping("/api/post/artist/")
    private Long save(@RequestBody ArtistSaveRequestDto requestDto) {
        return artistService.save(requestDto);
    }

}
