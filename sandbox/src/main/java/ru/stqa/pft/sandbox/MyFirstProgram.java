package ru.stqa.pft.sandbox;

public class MyFirstProgram{
	
	public static void main(String[]  args) {

        hello("World");
        hello("User");
        hello("Asya");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоуголоника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        System.out.println("Расстояние от точки с координатами " + p1.x + "," + p1.y + " до точки с координатами " + p2.x + "," + p2.y + " = " + p1.distance(p2));

    }

    public static void hello(String somebody) {
       System.out.println("Hello, " + somebody + "!");
    }


}