package pl.edu.service.competitor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competitor.Competitors;
import pl.edu.repository.competitor.ICompetitorRepository;
import pl.edu.service.competitor.ICompetitorService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompetitorService implements ICompetitorService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICompetitorRepository competitorRepository;

	@Override
	public void delete(Competitor competitor) {
        competitorRepository.delete(competitor);
	}

	@Override
	public void saveOrUpdate(Competitor competitor) {
        competitorRepository.saveOrUpdate(competitor);
	}

	@Override
	public void save(Competitor competitor) {
        competitorRepository.save(competitor);
	}

	@Override
	public boolean saveIfNew(Competitor competitor) {
		return false;
	}

	@Override
	public List<Competitor> list(Competitors competitors) {
		return competitorRepository.findAll().merge(competitors).list();
	}

	@Override
	public long count(Competitors competitors) {
		return competitorRepository.findAll().merge(competitors).count();
	}

	@Override
	public Competitor uniqueObject(Competitors competitors) {
		return competitorRepository.findAll().merge(competitors).uniqueObject();
	}


	@Override
	public void register(Competitor competitor) {
        competitorRepository.save(competitor);
	}

	@Override
	public void update(Competitor competitor) {
        competitorRepository.update(competitor);
	}

	@Override
	public boolean exists(Competitors competitors) {
        Competitor competitor = competitorRepository.findAll().merge(competitors).uniqueObject();
        competitorRepository.evict(competitor);
		return competitor != null;
	}
}
