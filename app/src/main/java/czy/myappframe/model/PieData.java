package czy.myappframe.model;

/**
 * Created by george on 2016/12/7.
 */

public class PieData {
    private String name;//名字
    private float value;//值
    private float angle;//角度
    private int color;//颜色


    public PieData(float value, float angle) {
        this.value = value;
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
