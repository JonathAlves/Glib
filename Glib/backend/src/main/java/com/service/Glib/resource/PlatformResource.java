package com.service.Glib.resource;

import com.service.Glib.services.PlatformService;
import com.service.Glib.services.dto.PlatformDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/glib/platforms")
@RequiredArgsConstructor
public class PlatformResource {
    @Autowired
    private PlatformService platformService;

    @GetMapping
    public ResponseEntity<List<PlatformDTO>> listPlatforms(){
        List<PlatformDTO> platforms = platformService.listPlatforms();
        return new ResponseEntity<>(platforms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformDTO> getPlatform(@PathVariable long id) throws Exception{
        return ResponseEntity.ok(platformService.getPlatform(id));
    }

    @PostMapping
    public ResponseEntity<PlatformDTO> createPlatform(PlatformDTO platformDTO){
        PlatformDTO platform = platformService.createPlatform(platformDTO);
        return ResponseEntity.created(URI.create("/glib/platforms")).body(platform);
    }

    @PutMapping
    public ResponseEntity<PlatformDTO> editPlatform(PlatformDTO platformDTO){
        PlatformDTO platform = platformService.editPlatform(platformDTO);
        return ResponseEntity.ok(platform);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable long id) throws Exception{
        platformService.deletePlatform(id);
    }
}
