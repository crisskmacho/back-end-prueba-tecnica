package com.example.demo.entities.custom;




public class StatusAmount {

    private int complete;
    private int cancelled;

    public StatusAmount(int complete, int cancelled){
        this.complete = complete;
        this.cancelled = cancelled;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
