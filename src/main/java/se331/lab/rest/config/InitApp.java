package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    AuctionItemRepository auctionItemRepository;
    @Autowired
    BidRepository bidRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        //Event builder
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        //Bid builder
        Bid tempBid;
        Bid[] bids = new Bid[15];
        Random rand = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i=0; i<bids.length;i++){
            String H = Integer.toString(rand.nextInt(24 - 10) + 10);
            String m = Integer.toString(rand.nextInt(60 - 10) + 10);
            String time = "2020-09-16 " + H + ":" + m;
            tempBid = bidRepository.save(Bid.builder()
                    .amount(rand.nextInt(99000000) + 1000000)
                    .datetime(LocalDateTime.parse(time, formatter))
                    .build());
            bids[i] = tempBid;
        }

        //AuctionItem builder
        AuctionItem tempAuctionItem;
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .description("The mummy of Princess Corco.")
                .type("human_part")
                .build());
        tempAuctionItem.setSuccessfulBid(bids[rand.nextInt(2)]);
        bids[0].setItem(tempAuctionItem);
        bids[1].setItem(tempAuctionItem);
        bids[2].setItem(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .description("Tissues used by the famous actor Sonne Limarch.")
                .type("item")
                .build());
        tempAuctionItem.setSuccessfulBid(bids[rand.nextInt(2) + 3]);
        bids[3].setItem(tempAuctionItem);
        bids[4].setItem(tempAuctionItem);
        bids[5].setItem(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .description("A Solid-Gold Execution Sword from the Yul National Treasury.")
                .type("item")
                .build());
        tempAuctionItem.setSuccessfulBid(bids[rand.nextInt(2) + 6]);
        bids[6].setItem(tempAuctionItem);
        bids[7].setItem(tempAuctionItem);
        bids[8].setItem(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .description("The last of its kind, a Celadon Porcelain Vase from the Lai Dynasty.")
                .type("item")
                .build());
        tempAuctionItem.setSuccessfulBid(bids[rand.nextInt(2) + 9]);
        bids[9].setItem(tempAuctionItem);
        bids[10].setItem(tempAuctionItem);
        bids[11].setItem(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .description("A pair of Scarlet Eyes from the Kurta Clan.")
                .type("human_part")
                .build());
        tempAuctionItem.setSuccessfulBid(bids[rand.nextInt(2) + 12]);
        bids[12].setItem(tempAuctionItem);
        bids[13].setItem(tempAuctionItem);
        bids[14].setItem(tempAuctionItem);
    }
}
