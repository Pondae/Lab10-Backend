package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {
    Long id;
    String description;
    String type;
    AuctionItemBidDTO successfulBid;
    List<AuctionItemBidDTO> bids = new ArrayList<>();
}
