package pl.edu.service.competition.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.competition.CompetitonInfos;
import pl.edu.repository.competition.ICompetitonInfoRepository;
import pl.edu.service.competition.ICompetitonInfoService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompetitonInfoService implements ICompetitonInfoService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICompetitonInfoRepository competitonInfoRepository;

	@Override
	public void delete(CompetitionInfo competitionInfo) {
        competitonInfoRepository.delete(competitionInfo);
	}

	@Override
	public void saveOrUpdate(CompetitionInfo competitionInfo) {
        competitonInfoRepository.saveOrUpdate(competitionInfo);
	}

	@Override
	public void save(CompetitionInfo competitionInfo) {
        competitonInfoRepository.save(competitionInfo);
	}

	@Override
	public boolean saveIfNew(CompetitionInfo competitionInfo) {
		return false;
	}

	@Override
	public List<CompetitionInfo> list(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).list();
	}

	@Override
	public long count(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).count();
	}

	@Override
	public CompetitionInfo uniqueObject(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).uniqueObject();
	}

	@Override
	public void update(CompetitionInfo competitionInfo) {
        competitonInfoRepository.update(competitionInfo);
	}

	@Override
	public boolean exists(CompetitonInfos competitonInfos) {
        CompetitionInfo competitionInfo = competitonInfoRepository.findAll().merge(competitonInfos).uniqueObject();
        competitonInfoRepository.evict(competitionInfo);
		return competitionInfo != null;
	}
}
