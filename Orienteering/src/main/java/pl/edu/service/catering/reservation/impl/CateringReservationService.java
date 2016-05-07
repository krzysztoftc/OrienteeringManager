package pl.edu.service.catering.reservation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.model.club.Club;
import pl.edu.repository.catering.reservation.CateringReservations;
import pl.edu.repository.catering.reservation.ICateringReservationRepository;
import pl.edu.repository.club.Clubs;
import pl.edu.service.catering.reservation.ICateringReservationService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CateringReservationService implements ICateringReservationService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICateringReservationRepository cateringReservationRepository;

	@Override
	public void delete(CateringReservation cateringReservation) {
		cateringReservationRepository.delete(cateringReservation);
	}

	@Override
	public void saveOrUpdate(CateringReservation cateringReservation) {
		cateringReservationRepository.saveOrUpdate(cateringReservation);
	}

	@Override
	public void save(CateringReservation cateringReservation) {
		cateringReservationRepository.save(cateringReservation);
	}

	@Override
	public boolean saveIfNew(CateringReservation cateringReservation) {
		return false;
	}

	@Override
	public List<CateringReservation> list(CateringReservations cateringReservations) {
		return cateringReservationRepository.findAll().merge(cateringReservations).list();
	}

	@Override
	public long count(CateringReservations cateringReservations) {
		return cateringReservationRepository.findAll().merge(cateringReservations).count();
	}

	@Override
	public CateringReservation uniqueObject(CateringReservations cateringReservations) {
		return cateringReservationRepository.findAll().merge(cateringReservations).uniqueObject();
	}

	@Override
	public void update(CateringReservation cateringReservation) {
		cateringReservationRepository.update(cateringReservation);
	}

	@Override
	public boolean exists(CateringReservations cateringReservations) {
        CateringReservation cateringReservation = cateringReservationRepository.findAll().merge(cateringReservations).uniqueObject();
		cateringReservationRepository.evict(cateringReservation);
		return cateringReservation != null;
	}
}
