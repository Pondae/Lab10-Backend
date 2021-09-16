package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

import java.util.Optional;

public interface AuctionItemDao {
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    Page<AuctionItem> getAuctionItem(String description, Pageable page);
    Optional<AuctionItem> findById(Long id);
}
