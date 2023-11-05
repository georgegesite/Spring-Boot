package com.rungroup.web.services;

import com.rungroup.web.models.Club;
import java.util.List;

public interface ClubService {
    List<Club> findAllClubs();

    Club saveClub(Club club);

    Club findClub(Long id);

    Club updateClub(Club club);

    void deleteClub(Long id);
}
