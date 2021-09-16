package se331.lab.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String description;
    String type;
    @OneToOne
    Bid successfulBid; //unique direction
    @OneToMany (mappedBy = "item")
    @Builder.Default
    List<Bid> bids = new ArrayList<>();
}
