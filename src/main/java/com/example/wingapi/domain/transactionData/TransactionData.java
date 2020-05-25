package com.example.wingapi.domain.transactionData;


import com.example.wingapi.domain.artist.Artist;
import com.example.wingapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name="artist_id")
    private Artist artist;

    private Long amount;
    private String datetime;
    private String uid;


    // TODO
    // User user 추가하기
    @Builder
    public TransactionData(User user, Artist artist, String uid, Long amount, String datetime) {
        this.user = user;
        this.artist = artist;
        this.uid = uid;
        this.amount = amount;
        this.datetime = datetime;

    }


}
