package it.istat.mec.regedit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class RegEditController {

	@GetMapping("/hello")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("I'm fine !");
    }
}
