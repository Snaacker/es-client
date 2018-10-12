package com.exa.tool.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonDataId {

    @JsonProperty("$oid")
    private String oid;

    public JsonDataId() {
    }

    public JsonDataId(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
