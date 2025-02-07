public class TOH {
    public static void toh(int n,String s,String h,String d)
    {
        if (n == 1) 
        {
            System.out.println("Move disk 1 from " + s + " to " + d);
            return;
        }
        else
        {
            toh(n-1, s, d, h);
            System.out.println("Move disk " + n + " from " + s + " to " + d);            
            toh(n-1, h, s, d);
        }
    }
    public static void main(String[] args) {
        toh(2,"Source","Helper","Destination");
    }
}
