package pl.edu.repository.competitor;

import pl.edu.model.competitor.Competitor;
import pl.edu.repository.IRepository;

public interface ICompetitorRepository extends IRepository<Competitor, Long> {

    Competitors findAll();
}
