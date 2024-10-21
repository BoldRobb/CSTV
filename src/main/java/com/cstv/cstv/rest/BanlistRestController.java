package com.cstv.cstv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.entities.Ids.BanlistId;
import com.cstv.cstv.service.BanlistService;

@RestController
@RequestMapping(value = "/api/banlist")
public class BanlistRestController {

    @Autowired
    private BanlistService banlistService;

    @GetMapping
    public List<Banlist> getAllBanlist() {
        return banlistService.findAll();
    }

    @GetMapping("/{idPartido}")
    public List<Banlist> getBanlistById(@PathVariable Long id) {
        return banlistService.findByIdPartido(id);
    }

    @PostMapping
    public Banlist createBanlist(@RequestBody Banlist banlist) {
        return banlistService.save(banlist);
    }


    @DeleteMapping("/{idPartido}/{Mapa}")
    public ResponseEntity<Void> deleteBanlistMapa(@PathVariable Long idPartido, @PathVariable String mapa) {
        BanlistId id = new BanlistId(idPartido, mapa);
        if (!banlistService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        banlistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPartido}")
    public ResponseEntity<Void> deleteBanlistPartido(@PathVariable Long idPartido){
        if (banlistService.findByIdPartido(idPartido).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        banlistService.deleteByIdPartido(idPartido);
        return ResponseEntity.noContent().build();
    }
}
