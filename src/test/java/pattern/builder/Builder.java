package pattern.builder;

import lombok.Getter;

public class Builder {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("BMW")
                .setColor("blue")
                .setMaxSpeed(250)
                .build();

        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getMaxSpeed());
    }
}

@Getter
class SportCar {
    private String name;
    private String color;
    private int maxSpeed;

    private SportCar(Builder builder) {
        this.color = builder.color;
        this.name = builder.name;
        this.maxSpeed = builder.maxSpeed;
    }

    static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }
}