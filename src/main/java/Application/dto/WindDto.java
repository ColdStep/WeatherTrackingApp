package Application.dto;

public class WindDto {

    private String speed;
    private String deg;

    public WindDto() {
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "WindDto{" +
                "speed='" + getSpeed()+ "mps"+'\'' +
                ", deg='" + getDeg()+ '\'' +
                '}';
    }}
