package cn.com.java.experiment;

public class BMI {
    private String gender;
    private double height;
    private double weight;

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BMI(String gender, double height, double weight) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public double BMICount() {
        return this.weight/(Math.pow(this.height, 2));
    }
}
