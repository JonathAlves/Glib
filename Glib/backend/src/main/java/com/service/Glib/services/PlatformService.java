package com.service.Glib.services;

import com.service.Glib.entities.Platform;
import com.service.Glib.repositories.IPlatformRepository;
import com.service.Glib.services.dto.PlatformDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PlatformService{
    @Autowired
    private IPlatformRepository platformRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Lista plataformas
    public List<PlatformDTO> listPlatforms(){
        List<Platform> platforms = platformRepository.findAll();
        return toDtoList(platforms);
    }

    //Busca uma plataforma
    public PlatformDTO getPlatform(long id) throws Exception{
        Platform platform = platformRepository.findById(id).orElseThrow(() -> new Exception("Plataforma não encontrada!"));
        return toDto(platform);
    }

    //Cria uma plataforma
    public PlatformDTO createPlatform(PlatformDTO platformDTO){
        Platform platform = toEntity(platformDTO);
        platformRepository.save(platform);
        return toDto(platform);
    }

    public PlatformDTO editPlatform(PlatformDTO platformDTO){
        Platform platform = toEntity(platformDTO);
        platformRepository.save(platform);
        return toDto(platform);
    }

    public void deletePlatform(long id) throws Exception{
        platformRepository.findById(id).orElseThrow(() -> new Exception("Plataforma não encontrada!"));
        platformRepository.deleteById(id);
    }

    public List<PlatformDTO> toDtoList(List<Platform> platforms){
        List<PlatformDTO> platformsDTO = new ArrayList<>();
        for(Platform platform : platforms){
            PlatformDTO platformDTO = modelMapper.map(platform, PlatformDTO.class);
            platformsDTO.add(platformDTO);
        }
        return platformsDTO;
    }

    public PlatformDTO toDto(Platform platform){
        PlatformDTO platformDTO = modelMapper.map(platform, PlatformDTO.class);
        return platformDTO;
    }

    public Platform toEntity(PlatformDTO platformDTO){
        Platform platform = modelMapper.map(platformDTO, Platform.class);
        return platform;
    }

    public List<Platform> toEntityList(List<PlatformDTO> platformsDTO){
        List<Platform> platforms = new ArrayList<>();
        for(PlatformDTO platformDTO : platformsDTO){
            Platform platform = modelMapper.map(platformDTO, Platform.class);
            platforms.add(platform);
        }
        return platforms;
    }
}
