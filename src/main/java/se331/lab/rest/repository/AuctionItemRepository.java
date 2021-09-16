package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.AuctionItem;


public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
}
