package com.cstv.cstv.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.domain.BanlistDTO;
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
    public List<Banlist> getBanlistById(@PathVariable Long idPartido) {
        return banlistService.findByIdPartido(idPartido);
    }

    @PostMapping
    public ResponseEntity<Banlist> createBanlist(@RequestBody BanlistDTO banlistDTO) {
        Banlist banlist = new Banlist();
        banlist.setId(new BanlistId(banlistDTO.getIdPartido(), banlistDTO.getMapa()));
        banlist.setIdPartido(banlistDTO.getIdPartido());
        banlist.setMapa(banlistDTO.getMapa());
        banlist.setEstatus(banlistDTO.getEstatus());
        banlist.setIdEquipo(banlistDTO.getIdEquipo());

        Banlist savedBanlist = banlistService.save(banlist);
        return ResponseEntity.ok(savedBanlist);
    }

    @PostMapping("/list")
    public List<Banlist> createBanlists(@RequestBody List<BanlistDTO> banlistDTOList) {
        List<Banlist> banlists = banlistDTOList.stream().map(dto -> {
            Banlist banlist = new Banlist();
            banlist.setId(new BanlistId(dto.getIdPartido(), dto.getMapa()));
            banlist.setIdPartido(dto.getIdPartido());
            banlist.setMapa(dto.getMapa());
            banlist.setEstatus(dto.getEstatus());
            banlist.setIdEquipo(dto.getIdEquipo());
            return banlist;
        }).collect(Collectors.toList());
        return banlistService.saveAll(banlists);
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