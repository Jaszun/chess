package com.company.Backend;

public class ChessClock extends Thread{
    private boolean isOn;
    private int gameLength;
    private String timeLeft = "";

    public ChessClock (String name, boolean isOn, int gameLength){
        this.setName(name);
        this.isOn = isOn;
        this.gameLength = gameLength;
    }

    @Override
    public void run() {
        long i = gameLength * 60 * 1000;

        while (true){
            if (isOn){
                long minutes = i / (60 * 1000);
                long seconds = i % (60 * 1000) / 1000;

                timeLeft = String.format("%d:%02d", minutes, seconds);

                System.out.println(this.getName() + " " + timeLeft);

                i -= 1000;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getTimeLeft() {
        return timeLeft;
    }
}
