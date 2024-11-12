package com.cstv.cstv.rest;

import com.cstv.cstv.entities.NoticiaMain;
import com.cstv.cstv.entities.TorneoMain;
import com.cstv.cstv.repos.NoticiaMainRepo;
import com.cstv.cstv.repos.TorneoMainRepo;
import com.cstv.cstv.service.TorneoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/torneoMain")
public class TorneoMainRestController {
    @Autowired
    TorneoMainService torneoMainService;
    @GetMapping
    public TorneoMain geNoticiaMain() {
        return torneoMainService.find();
    }

    @GetMapping("/delete")
    public void deleteAll() {
        torneoMainService.deleteAll();
    }

    @PostMapping("/{id}")
    public TorneoMain saveNoticiaMain(@PathVariable Long id) {
        TorneoMain entity = new TorneoMain();
        entity.setId(id);
        return torneoMainService.save(entity);
    }
}
