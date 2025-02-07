package com.example.web.service.impl;

import com.example.web.dto.ClubDto;
import com.example.web.models.Club;
import com.example.web.repository.ClubRepository;
import com.example.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }
    @Override
    public List<ClubDto> findAllClubs(){
        List<Club> clubs = clubRepository.findAll();

        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto (Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}
