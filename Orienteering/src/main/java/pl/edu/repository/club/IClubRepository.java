package pl.edu.repository.club;


import pl.edu.model.club.Club;
import pl.edu.repository.IRepository;

public interface IClubRepository extends IRepository<Club, Long> {

	Clubs findAll();
}
