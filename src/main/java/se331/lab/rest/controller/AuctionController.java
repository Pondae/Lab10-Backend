package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.service.AuctionItemService;
import se331.lab.rest.util.LabMapper;

@RestController
public class AuctionController {
    @Autowired
    AuctionItemService auctionItemService;
    @GetMapping("auctionItems")
    public ResponseEntity<?> getAuctionItemLists(
            @RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "description", required = false) Integer description) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> pageOutput;
        if (description == null){
            pageOutput = auctionItemService.getAuctions(perPage,page);
        }else {
            pageOutput = auctionItemService.getAuctions(description, PageRequest.of(page-1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDto(pageOutput.getContent()),responseHeader, HttpStatus.OK);

    }
}