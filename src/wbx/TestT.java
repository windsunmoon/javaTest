import java.util.ArrayList;
import java.util.List;


public class TestT {


    public static void main(String[] args) {


       List<? super Fruit> f0=new ArrayList<Fruit>();
       
       
       
       f0.add(new Apple());
       f0.add(new Fruit());
       f0.add(new SupApple());
       
       List<? super Fruit> f1=new ArrayList<Apple>();
       f1.add(new Apple());
       f1.add(new Fruit());
       
       List<? extends Fruit> f2=new ArrayList<Fruit>();
       f2.add(new Apple());
       f2.add(new Fruit());
       
       
       List<? extends Fruit> f3=new ArrayList<Apple>();
       f3.add(new Apple());
       f3.add(new Fruit());
        
       List<? super Apple> f5=new ArrayList<Fruit>();
       f5.add(new Apple());
       f5.add(new SupApple());
       f5.add(new Fruit());
    }
}


class Fruit{
}


class Apple extends Fruit{
}


class SupApple extends Apple{    
}