package org.crossasia.manifest.attributes.domain;

import java.util.List;

public class ScriptInfo {
    private List<String> scripts;
    private String usedScripts;
    private String scriptIdRole;
    private String language;
    private List<String> languages;

    public ScriptInfo() {}

    // Getters and setters
    public List<String> getScripts() { return scripts; }
    public void setScripts(List<String> scripts) { this.scripts = scripts; }

    public String getUsedScripts() { return usedScripts; }
    public void setUsedScripts(String usedScripts) { this.usedScripts = usedScripts; }

    public String getScriptIdRole() { return scriptIdRole; }
    public void setScriptIdRole(String scriptIdRole) { this.scriptIdRole = scriptIdRole; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }
}