
public class IDrawableTest {
    public static void main(String[] args) {
        IDrawable[] drawables = {new Triangle(3, 4), new Circle(5), new Image("a.gif"), new Triangle(2, 4)};

        for (IDrawable drawable : drawables)
            drawable.draw();
        System.out.println("End of drawing" + "\n");

        for (IDrawable drawable : drawables)
            System.out.println(drawable);
        System.out.println("End of printing" + "\n");

        for (IDrawable drawable : drawables) {
            if (drawable instanceof Shape) {
                System.out.print(drawable);
                System.out.println(" area=" + ((Shape) drawable).getArea());
            }
        }
        System.out.println("End of gettingArea" + "\n");

        IDrawable triangle = new Triangle(2, 4);
        System.out.println("The drawable object (" + triangle + ") is equal to the following object:");
        for (int i = 0; i < drawables.length; i++) {
            if (drawables[i].equals(triangle)) {
                System.out.println(i + "th element (" + drawables[i] + ")");
            }
        }
        System.out.println("End of comparison" + "\n");
    }
}


interface IDrawable {

    abstract void draw();

}

class Shape implements IDrawable  {
    @Override
    public void draw() {}

    public double getArea() { return 0; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shape) {
            Shape s = (Shape) obj;
            if(this.toString().equals(s.toString())) {
                return true;
            }
        }
        return false;
    }

}
class Triangle extends Shape{
    int x;
    int y;
    String result = "";

    Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        result = (String)("Triangle : width=" + x + " height=" + y);

        return result;
    }

    public void draw() {
        System.out.println("삼각형을 그리자 : width=" + x + ", height=" + y);
    }

    public double getArea() {
        return (double)( (x * y) / 2);
    }



}

class Circle extends Shape{
    int r;
    String result = "";
    Circle(int r) {
        this.r = r;
    }

    public String toString() {
        String result = "Circle : radius=" + r;

        return result;
    }

    public void draw() {
        System.out.println("원을 그리자 : radius=" + r);
    }

    public double getArea() {
        return (double)( 3.14 * r * r);
    }


}

class Image implements IDrawable {
    String file;


    Image(String file) {
        this.file = file;
    }

    public String toString() {
        String result = "Image : fileName=" + file;

        return result;
    }

    public void draw() {
        System.out.println("이미지를 그리자 : fileName=" + file);
    }


}


