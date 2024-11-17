package org.hacienda.verifierproto.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
public class PluginController {


    @GetMapping("/lade-plugin")
    public ResponseEntity<String> ladePlugin(){

        log.info("lade-plugin wurde aktiviert");

        try{

            Path filePath = Paths.get("C:\\Projekte\\VerifierProto\\src\\main\\resources\\static\\plugin.html");
            String htmlContent = Files.readString(filePath, StandardCharsets.UTF_8);
            log.info("html plugin: " +htmlContent);
            return ResponseEntity.ok(htmlContent);


            // so kann man zwei exp gleichzeitig abfeangen
        }catch(ResourceAccessException | IOException e){
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }



}
