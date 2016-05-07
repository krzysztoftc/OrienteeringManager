package pl.edu.service.catering.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.catering.Catering;
import pl.edu.repository.catering.Caterings;
import pl.edu.repository.catering.ICateringRepository;
import pl.edu.service.catering.ICateringService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CateringService implements ICateringService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICateringRepository cateringRepository;

	@Override
	public void delete(Catering catering) {
		cateringRepository.delete(catering);
	}

	@Override
	public void saveOrUpdate(Catering catering) {
		cateringRepository.saveOrUpdate(catering);
	}

	@Override
	public void save(Catering catering) {
		cateringRepository.save(catering);
	}

	@Override
	public boolean saveIfNew(Catering catering) {
		return false;
	}

	@Override
	public List<Catering> list(Caterings caterings) {
		return cateringRepository.findAll().merge(caterings).list();
	}

	@Override
	public long count(Caterings caterings) {
		return cateringRepository.findAll().merge(caterings).count();
	}

	@Override
	public Catering uniqueObject(Caterings caterings) {
		return cateringRepository.findAll().merge(caterings).uniqueObject();
	}

	@Override
	public void update(Catering catering) {
		cateringRepository.update(catering);
	}

	@Override
	public boolean exists(Caterings caterings) {
        Catering catering = cateringRepository.findAll().merge(caterings).uniqueObject();
		cateringRepository.evict(catering);
		return catering != null;
	}
}
