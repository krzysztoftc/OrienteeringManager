package pl.edu.repository.competition;

import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.IRepository;

public interface ICompetitionInfoRepository extends IRepository<CompetitionInfo, Long> {

    CompetitionInfos findAll();
}
