package com.rungroup.web.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.services.ClubService;

@Service
public class ClubServiceImpl implements ClubService {
    // Bring in Repository, used in Service for Abstraction
    private ClubRepository clubRepository;

    // Create Constructor for Club Repository
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }
    
    @Override
    public Club findClub(Long id)
    {
    	return clubRepository.findById(id).get();
    }
    
    @Override
    public Club updateClub(Club club)
    {   
    	return clubRepository.save(club);
    }
}
