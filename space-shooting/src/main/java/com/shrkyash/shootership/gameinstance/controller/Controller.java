package com.shrkyash.shootership.gameinstance.controller;

public abstract class Controller<T> {
    private Controller<T> nextController;

    public void setNextController(Controller<T> nextController) {
        this.nextController = nextController;
    }

    public abstract void update(T state);

    public void execute(T state) {
        update(state);
        if(nextController != null){
            nextController.execute(state);
        }
    }
}
