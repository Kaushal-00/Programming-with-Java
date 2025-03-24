## Practical-4.3:

- Define following classes and interfaces.
    
     ````
      public interface GeometricShape {
        public void describe();
      }
     ````

     ````
      public interface TwoDShape extends GeometricShape {
        public double area();
      }
     ````
    
     ````
      public interface ThreeDShape extends GeometricShape {
        public double volume();
      }
     ````
      
     ````
      public class Cone implements ThreeDShape {
        private double radius;
        private double height;
        public Cone (double radius, double height)
        public double volume()
        public void describe()
      }
     ````
    
     ````
      public class Rectangle implements TwoDShape {
        private double width, height;
        public Rectangle (double width, double height)
        public double area()
        public double perimeter()
        public void describe()
      }
     ````
    
     ````
      public class Sphere implements ThreeDShape {
        private double radius;
        public Sphere (double radius)
        public double volume()
        public void describe()
      }
     ````

- Define test class to call various methods of Geometric Shape.