package org.hacienda.verifierproto.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebSiteInhalteWrapper {
    // irgendein objekt das halt die eigenschaften hält die sone website abschicken kann
    // für den simplen fall einfach nur den gesamten text der seite, könnte ja bestimmt komplexer sein
    private final String[] seitenText;

    public WebSiteInhalteWrapper(@JsonProperty("text") String[] text) {
        this.seitenText = text;
    }

    public String[] getSeitenText() {
        return seitenText;
    }


}
