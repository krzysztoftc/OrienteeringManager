package pl.edu.service.club.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.club.Club;
import pl.edu.repository.club.Clubs;
import pl.edu.repository.club.IClubRepository;
import pl.edu.service.club.IClubService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClubService implements IClubService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private IClubRepository clubRepository;

	@Override
	public void delete(Club club) {
		clubRepository.delete(club);
	}

	@Override
	public void saveOrUpdate(Club club) {
		clubRepository.saveOrUpdate(club);
	}

	@Override
	public void save(Club club) {
		clubRepository.save(club);
	}

	@Override
	public boolean saveIfNew(Club club) {
		return false;
	}

	@Override
	public List<Club> list(Clubs clubs) {
		return clubRepository.findAll().merge(clubs).list();
	}

	@Override
	public long count(Clubs clubs) {
		return clubRepository.findAll().merge(clubs).count();
	}

	@Override
	public Club uniqueObject(Clubs clubs) {
		return clubRepository.findAll().merge(clubs).uniqueObject();
	}

	@Override
	public void register(Club club) {
		clubRepository.save(club);
	}

	@Override
	public void update(Club club) {
		clubRepository.update(club);
	}

	@Override
	public boolean exists(Clubs clubs) {
		Club club = clubRepository.findAll().merge(clubs).uniqueObject();
		clubRepository.evict(club);
		return club != null;
	}
}
