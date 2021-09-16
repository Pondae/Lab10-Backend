package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AuctionItemDao;
import se331.lab.rest.entity.AuctionItem;

@Service
public class AuctionItemServiceImpl implements AuctionItemService{
    @Autowired
    AuctionItemDao auctionItemDao;

    @Override
    public Page<AuctionItem> getAuctions(Integer description, Pageable pageable) {
        return auctionItemDao.getAuctionItem(description, pageable);
    }
    @Override
    public Page<AuctionItem> getAuctions(Integer perPage, Integer page) {
        return auctionItemDao.getAuctionItems(perPage, page);
    }
}
