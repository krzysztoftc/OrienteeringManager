package pl.edu.service.competition.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.competition.CompetitonInfo;
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
	public void delete(CompetitonInfo competitonInfo) {
        competitonInfoRepository.delete(competitonInfo);
	}

	@Override
	public void saveOrUpdate(CompetitonInfo competitonInfo) {
        competitonInfoRepository.saveOrUpdate(competitonInfo);
	}

	@Override
	public void save(CompetitonInfo competitonInfo) {
        competitonInfoRepository.save(competitonInfo);
	}

	@Override
	public boolean saveIfNew(CompetitonInfo competitonInfo) {
		return false;
	}

	@Override
	public List<CompetitonInfo> list(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).list();
	}

	@Override
	public long count(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).count();
	}

	@Override
	public CompetitonInfo uniqueObject(CompetitonInfos competitonInfos) {
		return competitonInfoRepository.findAll().merge(competitonInfos).uniqueObject();
	}

	@Override
	public void update(CompetitonInfo competitonInfo) {
        competitonInfoRepository.update(competitonInfo);
	}

	@Override
	public boolean exists(CompetitonInfos competitonInfos) {
        CompetitonInfo competitonInfo = competitonInfoRepository.findAll().merge(competitonInfos).uniqueObject();
        competitonInfoRepository.evict(competitonInfo);
		return competitonInfo != null;
	}
}
