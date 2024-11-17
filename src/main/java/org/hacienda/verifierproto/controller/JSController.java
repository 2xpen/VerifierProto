package org.hacienda.verifierproto.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.hacienda.verifierproto.ErlaubteSeite;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Log
@Controller
public class JSController {


    @GetMapping("/lade-script")
    public ResponseEntity<String> validierJSAufruf(
            HttpServletRequest request,
            @RequestParam String token) throws URISyntaxException {

        // HIER IST DIE VALIDIERUNG, IM FALLE TOKEN UND URL STIMMEN NICHT WIRD UNBEKANNT ÜBERGEBEN
        ErlaubteSeite erlaubteSeite = ErlaubteSeite.ofTokenAndURL(token, request.getRequestURL().toString());


log.info("Uri aus Request: " + request.getRequestURI());
URI uri = new URI(request.getRequestURL().toString());
log.info("Uri: " + uri.getHost());

        if (erlaubteSeite.equals(ErlaubteSeite.UNBEKANNT)) {

            log.info("UNERLAUBTE ANFRAGE AUF DAS JAVASCRIPT "
                    + "\n token: " + token
                    + "\n url: " + request.getRequestURL().toString());


            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Authentifizierung fehlgeschlagen");
        } else {

            log.info(erlaubteSeite.getUrl() + " hat das javascript erfolgreich angefrag t");

            //LADEN VON DER JS DATEI
            try {
                ClassPathResource jsFile = new ClassPathResource("static/kiapi.js");

                String jsContent = StreamUtils.copyToString(jsFile.getInputStream(), StandardCharsets.UTF_8);
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsContent);

            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error loading JavaScript file.");
            }
        }

        }


        @GetMapping("/lade-collecttextjs")
        public ResponseEntity<String> getCollectTextJS(){
                log.info("lade collecttextjs ausgelöst");
                //LADEN VON DER JS DATEI
                try {
                    ClassPathResource jsFile = new ClassPathResource("static/collectText.js");

                    String jsContent = StreamUtils.copyToString(jsFile.getInputStream(), StandardCharsets.UTF_8);
                    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsContent);

                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error loading JavaScript file.");
                }

            }

        }




