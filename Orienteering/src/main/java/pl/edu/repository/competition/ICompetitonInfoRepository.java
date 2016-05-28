package pl.edu.repository.competition;

import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.IRepository;

public interface ICompetitonInfoRepository extends IRepository<CompetitionInfo, Long> {

    CompetitonInfos findAll();
}
