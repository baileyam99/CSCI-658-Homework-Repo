package Homework_5;

public class Roots
{
   static double num_roots, root_one, root_two;

   public static void calculate_roots(double a, double b, double c)
   {
      double q, r;

      if(a==0){
      num_roots = 0;
      root_one = -1;
      root_two = -1;
      return;
      }

      q= b*b - 4*a*c;

      if(q>0){
      num_roots =2;
      r=(double) Math.sqrt(q);
      root_one =((0-b)+r)/(2*a);
      root_two =((0-b)-r)/(2*a);
      }else if(q==0){
      num_roots = 1;
      root_one = (0-b)/(2*a);
      root_two=root_one;
      } else
      {
      num_roots = 0;
      root_one =-1;
      root_two = -1;

      }

    }

    public static double num_roots()
    {
          return num_roots;

    }

    public static double first_root()
    {
      return root_one;

    }

    public static double second_root()
    {
         return root_two;

    }
}
