package com.albo.comic.rest.entities;

import java.util.List;

public class ColaboratorsResponse {
    private String lastSync;
    private List<String> editors;
    private List<String> writers;
    private List<String> colorists;

    public String getLastSync() { return lastSync; }
    public void setLastSync(String value) { this.lastSync = value; }

    public List<String> getEditors() { return editors; }
    public void setEditors(List<String> value) { this.editors = value; }

    public List<String> getWriters() { return writers; }
    public void setWriters(List<String> value) { this.writers = value; }

    public List<String> getColorists() { return colorists; }
    public void setColorists(List<String> value) { this.colorists = value; }
}

