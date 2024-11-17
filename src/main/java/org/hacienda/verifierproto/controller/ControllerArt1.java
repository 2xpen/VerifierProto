package org.hacienda.verifierproto.controller;

import org.hacienda.verifierproto.wrapper.WebSiteInhalteWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class ControllerArt1 {

    @PostMapping("/ubergabewebsitetext")
    public ResponseEntity<Void> accecptText(@RequestBody WebSiteInhalteWrapper inhalt) {

        //hier quasi nichts zurückgeben, sondern einfach nur füttern, nur dem client sagen ob das geklappt hat oder nicht
        System.out.println(Arrays.toString(inhalt.getSeitenText()) + " das ist der ubergeben text");
        return ResponseEntity.ok().build();
    }

}
