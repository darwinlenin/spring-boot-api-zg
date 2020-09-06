package com.zoegeop.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @Transient
    private String textInSomeLanguage;

    public Greeting() {
        super();
    }

    public Greeting(String text) {
        super();
        this.text = text;
        this.textInSomeLanguage = getTextTranslationInSpecifiedLanguage(text);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}