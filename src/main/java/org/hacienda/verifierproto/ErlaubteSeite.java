package org.hacienda.verifierproto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ErlaubteSeite {


    //vereinfachte darstellung vom Authentifizieren, würde in einer tatsächlichen implementation natürlich anders ablaufen

    KUNDE_A("web.de","123455"),
    KUNDE_B("hunde.de","99999999"),
    TESTFALL("http://localhost:8080/lade-script","1234"),
    TESTFALL_KORREKT("localhost","1234"),
    UNBEKANNT("","");

    private final String url;
    private final String token;

    private ErlaubteSeite(String url, String token) {
        this.url = url;
        this.token = token;
    }



    // möglich dass seperates abfragen sinn ergibt wenn man rausfinden will ob token oder url falsch ist****************
    public static ErlaubteSeite ofUrl(String url){
        return Arrays.stream(ErlaubteSeite.values())
                .filter(e -> e.url.equals(url))
                .findFirst()
                .orElse(ErlaubteSeite.UNBEKANNT);
    }

    public static ErlaubteSeite ofToken(String token){
        return
                Arrays.stream(ErlaubteSeite.values())
                .filter(e -> e.token.equals(token))
                .findFirst()
                .orElse(ErlaubteSeite.UNBEKANNT);
    }
    //*******************************************************************************************************************


    //hier kombinierte Abfrage******************************************************************************************
    public static ErlaubteSeite ofTokenAndURL(String token, String url){
        return
                Arrays.stream(ErlaubteSeite.values())
                .filter(e -> e.token.equals(token) && e.url.equals(url))
                .findFirst()
                .orElse(UNBEKANNT);
    }



}
