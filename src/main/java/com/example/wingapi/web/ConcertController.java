package com.example.wingapi.web;

import com.example.wingapi.service.ConcertService;
import com.example.wingapi.web.dto.concert.ConcertResponseDto;
import com.example.wingapi.web.dto.concert.ConcertSaveRequestDto;
import com.example.wingapi.web.dto.concert.ConcertUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Concert Controller"})
@AllArgsConstructor
@RestController
@CrossOrigin
public class ConcertController {

    private final ConcertService concertService;

    @ApiOperation(value = "콘서트 조회", notes = "기본 키 (consert_id)로 조회")
    @GetMapping("/api/concert/{id}")
    private ConcertResponseDto findById(@PathVariable("id") Long id) {
        return concertService.findById(id);
    }


    @ApiOperation(value = "콘서트 검색", notes = "이름으로 검색 후 JSON 리스트로 반환. name 파라미터 필요.")
    @GetMapping("/api/concert")
    private List<ConcertResponseDto> findByName(@RequestParam("name") String name) {
        return concertService.findByNameContaining(name);
    }


    @ApiOperation(value = "콘서트 등록", notes = "콘서트 등록")
    @PostMapping("/api/concert")
    private Long save(@RequestBody ConcertSaveRequestDto requestDto) {
        return concertService.save(requestDto);
    }


    @ApiOperation(value = "콘서트 수정", notes = "콘서트 수정")
    @PutMapping("/api/concert/{id}")
    private Long update(@PathVariable Long id, @RequestBody ConcertUpdateRequestDto requestDto) {
        return concertService.update(id, requestDto);
    }


    @ApiOperation(value = "콘서트 삭제", notes = "콘서트 삭제")
    @DeleteMapping("api/concert/{id}")
    private Long delete(@PathVariable Long id) { return concertService.delete(id); }
}
