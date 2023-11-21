package com.rungroup.web.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rungroup.web.dto.ClubDto;
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
    public Club findClub(Long id) {
        return clubRepository.findById(id).get();
    }

    @Override
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<Club> searchClubs(String query){
        List<Club> clubs = clubRepository.searcClubs(query);
        return clubs.stream().map(club ->  ).collect(Collectors.toList());
    }

    private ClubDto mapToClub(Club club) {
        ClubDto clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }
}
