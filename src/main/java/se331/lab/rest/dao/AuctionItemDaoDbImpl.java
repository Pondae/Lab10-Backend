package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.repository.AuctionItemRepository;

import java.util.Optional;

@Repository
public class AuctionItemDaoDbImpl implements AuctionItemDao{
    @Autowired
    AuctionItemRepository auctionItemRepository;
    @Override
    public Page<AuctionItem> getAuctionItem(String description, Pageable page) {
        return auctionItemRepository.findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContaining(description, description, page);
    }
    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Optional<AuctionItem> findById(Long id) {
        return auctionItemRepository.findById(id);
    }
}