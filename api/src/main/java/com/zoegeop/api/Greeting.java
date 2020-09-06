package com.zoegeop.api;

@Entity
public class Greeting{
    @Id
    @GenerateValue
    private Long id;

    @Column
    private String message;

    public Greeting(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Greeting(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId(){
        return id;
    }
}