package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

public interface AuctionItemService {
    Page<AuctionItem> getAuctions(Integer pageSize, Integer page);
    Page<AuctionItem> getAuctions(String description, Pageable pageable);
}
