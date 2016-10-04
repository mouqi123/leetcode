public class Divide29{
    public static int divide(int dividend,int divisor){
        int sig=-1;
        if((dividend<0&&divisor<0)||(dividend>0&&divisor>0))
            sig=1;
        int c=0;
        long x=Math.abs((long)dividend);
        long y=Math.abs((long)divisor);
        if(divisor==1) return dividend;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        while(x>=y){
            long a=y;
            long m=1;
            while((a<<1)<x){
                a<<=1; m<<=1;
            }
            c+=m;
            x-=a;
        }
        return sig*c;
    }
    public static void main(String[] args){
	System.out.println(divide(1,-1));
	System.out.println(divide(-99,10));
	System.out.println(divide(-9,10));
	System.out.println(divide(2147483647,1));
	System.out.println(divide(-1010369383,-2147483648));
    }
}
