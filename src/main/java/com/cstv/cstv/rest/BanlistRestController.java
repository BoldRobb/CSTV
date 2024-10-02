package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.service.BanlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/banlist")
public class BanlistRestController {

    @Autowired
    private BanlistService banlistService;

    @GetMapping
    public List<Banlist> getAllBanlist() {
        return banlistService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banlist> getBanlistById(@PathVariable Long id) {
        return banlistService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Banlist createBanlist(@RequestBody Banlist banlist) {
        return banlistService.save(banlist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banlist> updateBanlist(@PathVariable Long id, @RequestBody Banlist banlist) {
        if (!banlistService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(banlistService.save(banlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanlist(@PathVariable Long id) {
        if (!banlistService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        banlistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
