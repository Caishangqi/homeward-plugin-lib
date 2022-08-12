package javatest;

import kotlintest.classess.Rectangle;

public class TestKotlinJava {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        rectangle.destroy();
        System.out.println(rectangle.getPerimeter());
    }
}
