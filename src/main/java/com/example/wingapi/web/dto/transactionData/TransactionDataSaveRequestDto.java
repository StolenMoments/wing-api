package com.example.wingapi.web.dto.transactionData;

import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.transactionData.TransactionData;
import com.example.wingapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class TransactionDataSaveRequestDto {

    private Long amount;
    private String datetime;
    private String uid;
    private Long artistId;
    private String userId;

    @Builder
    public TransactionDataSaveRequestDto(String userId, Long artistId, Long amount, String datetime, String uid) {
        this.amount = amount;
        this.datetime = datetime;
        this.uid = uid;
        this.artistId = artistId;
        this.userId = userId;
    }


    // TODO
    // 파라미터에 User user 추가, 빌더에 user 추가하기
    public TransactionData toEntity(User user, Artist artist) {
        return TransactionData.builder()
                .user(user)
                .artist(artist)
                .amount(amount)
                .datetime(datetime)
                .uid(uid)
                .build();
    }

}
