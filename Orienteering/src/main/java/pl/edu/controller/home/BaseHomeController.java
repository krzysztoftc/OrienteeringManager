package pl.edu.controller.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorOptionsList;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.accommodation.reservation.AccommodationReservations;
import pl.edu.repository.catering.reservation.CateringReservations;
import pl.edu.repository.competition.CompetitionInfos;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.service.accommodation.reservation.IAccommodationReservationService;
import pl.edu.service.catering.ICateringService;
import pl.edu.service.catering.reservation.ICateringReservationService;
import pl.edu.service.competition.ICompetitionInfoService;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bartosz on 31.05.16.
 */
public class BaseHomeController extends BaseController {

    @Autowired
    protected ICompetitionInfoService competitionInfoService;

    @Autowired
    protected ICateringService cateringService;

    @Autowired
    protected IAccommodationService accommodationService;

    @Autowired
    protected ICateringReservationService cateringReservationService;

    @Autowired
    protected IAccommodationReservationService accommodationReservationService;

    @ModelAttribute("days")
    public List<String> daysList() {
        CompetitionInfo compInfo = competitionInfoService.uniqueObject(CompetitionInfos.findAll());
        Date begin = compInfo.getBegin();
        Date end = compInfo.getEnd();

        Calendar cStart = Calendar.getInstance(),
                cStop = Calendar.getInstance();

        cStart.setTime(begin);
        cStop.setTime(end);

        List<String> days = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        do {
            days.add(df.format(cStart.getTime()));
            cStart.add(Calendar.DAY_OF_YEAR, 1);
        } while (cStart.before(cStop));

        return days;
    }

    protected void updateCateringReservations(CompetitorOptionsList options){
        // Getting list of current catering reservations
        List<CateringReservation> cateringReservationsList =
                cateringReservationService.list(CateringReservations.findAll().withCompetitorId(options.getCompetitor()));

        // Removing old catering reservations
        for(CateringReservation cr : cateringReservationsList){
            cateringReservationService.delete(cr);
        }
        System.out.println("Deleted old catering reservations");

        // Adding new catering reservations
        for(Long id : options.getCaterings()){
            CateringReservation cr = new CateringReservation();
            cr.setCompetitorId(options.getCompetitor());
            cr.setCateringAvailabilityId(id);
            cateringReservationService.saveOrUpdate(cr);
        }
        System.out.println("Added new catering reservations");
    }

    protected void updateAccommodationReservations(CompetitorOptionsList options){
        // Getting list of current accommodation reservations
        List<AccommodationReservation> accommodationReservationsList =
                accommodationReservationService.list(AccommodationReservations.findAll().withCompetitorId(options.getCompetitor()));

        // Removing old accommodation reservations
        for(AccommodationReservation ar : accommodationReservationsList){
            accommodationReservationService.delete(ar);
        }
        System.out.println("Deleted old accommodation reservations");

        // Adding new accommodation reservations
        for(Long id : options.getNights()){
            AccommodationReservation ar = new AccommodationReservation();
            ar.setCompetitorId(options.getCompetitor());
            ar.setAccommodationAvailability(id);
            accommodationReservationService.saveOrUpdate(ar);
        }
        System.out.println("Added new accommodation reservations");
    }

    protected void saveCompetitorToDB(String jsonString){
        try {
            String decodedString = URLDecoder.decode(jsonString, "UTF-8");
            System.out.println(decodedString);

            ObjectMapper mapper = new ObjectMapper();
            CompetitorOptionsList options = mapper.readValue(decodedString, CompetitorOptionsList.class);

            updateCateringReservations(options);
            updateAccommodationReservations(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
