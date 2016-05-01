package pl.edu.repository.competition;

import pl.edu.model.competition.CompetitonInfo;
import pl.edu.repository.IRepository;

public interface ICompetitonInfoRepository extends IRepository<CompetitonInfo, Long> {

    CompetitonInfos findAll();
}
