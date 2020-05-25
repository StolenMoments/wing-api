package com.example.wingapi.web.dto.transactionData;

import com.example.wingapi.domain.transactionData.TransactionData;
import lombok.Getter;


@Getter
public class TransactionDataResponseDto {

    private final String artistName;
    private final String userName;
    private final Long amount;
    private final String datetime;

    public TransactionDataResponseDto(TransactionData transactionData) {
        this.artistName = transactionData.getArtist().getArtistName();
        this.userName = transactionData.getUser().getName();
        this.amount = transactionData.getAmount();
        this.datetime = transactionData.getDatetime();
    }
}
