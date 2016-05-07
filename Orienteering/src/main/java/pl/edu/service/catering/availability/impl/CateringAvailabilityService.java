package pl.edu.service.catering.availability.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.catering.availability.CateringAvailability;
import pl.edu.repository.catering.availability.CateringAvailabilities;
import pl.edu.repository.catering.availability.ICateringAvailabilityRepository;
import pl.edu.service.catering.availability.ICateringAvailabilityService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CateringAvailabilityService implements ICateringAvailabilityService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICateringAvailabilityRepository cateringAvailabilityRepository;

	@Override
	public void delete(CateringAvailability cateringAvailability) {
		cateringAvailabilityRepository.delete(cateringAvailability);
	}

	@Override
	public void saveOrUpdate(CateringAvailability cateringAvailability) {
		cateringAvailabilityRepository.saveOrUpdate(cateringAvailability);
	}

	@Override
	public void save(CateringAvailability cateringAvailability) {
		cateringAvailabilityRepository.save(cateringAvailability);
	}

	@Override
	public boolean saveIfNew(CateringAvailability cateringAvailability) {
		return false;
	}

	@Override
	public List<CateringAvailability> list(CateringAvailabilities cateringAvailabilities) {
		return cateringAvailabilityRepository.findAll().merge(cateringAvailabilities).list();
	}

	@Override
	public long count(CateringAvailabilities clubs) {
		return cateringAvailabilityRepository.findAll().merge(clubs).count();
	}

	@Override
	public CateringAvailability uniqueObject(CateringAvailabilities cateringAvailabilities) {
		return cateringAvailabilityRepository.findAll().merge(cateringAvailabilities).uniqueObject();
	}

	@Override
	public void update(CateringAvailability cateringAvailability) {
		cateringAvailabilityRepository.update(cateringAvailability);
	}

	@Override
	public boolean exists(CateringAvailabilities cateringAvailabilities) {
		CateringAvailability cateringAvailability = cateringAvailabilityRepository.findAll().merge(cateringAvailabilities).uniqueObject();
		cateringAvailabilityRepository.evict(cateringAvailability);
		return cateringAvailability != null;
	}
}
