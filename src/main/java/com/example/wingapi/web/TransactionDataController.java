package com.example.wingapi.web;


import com.example.wingapi.service.TransactionDataService;
import com.example.wingapi.web.dto.transactionData.TransactionDataResponseDto;
import com.example.wingapi.web.dto.transactionData.TransactionDataSaveRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Api(tags = {"Transaction Data Controller"})
@RestController
@AllArgsConstructor
@CrossOrigin
public class TransactionDataController {

    private final TransactionDataService transactionDataService;

    @ApiOperation(value = "트랜잭션 정보 조회", notes = "아티스트 id 필요")
    @GetMapping("/api/transaction/artist/{id}")
    private Set<TransactionDataResponseDto> findByArtist(@PathVariable("id") Long id) {
        return transactionDataService.findByArtist(id);
    }

//    @ApiOperation(value = "트랜잭션 정보 조회", notes = "유저 id 필요")
//    @GetMapping("/api/transaction/user/{id}")
//    private Set<TransactionDataResponseDto> findByUser(@PathVariable("id") String id) {
//        return transactionDataService.findByUser(id);
//    }

    @ApiOperation(value = "트랜잭션 정보 저장")
    @PostMapping("/api/transaction/")
    private Long save(@RequestBody TransactionDataSaveRequestDto requestDto) {
        return transactionDataService.save(requestDto);
    }

}
