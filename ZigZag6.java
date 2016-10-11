package aa;
/**
 * zigzag pattern:
 *
 * Δ=2n-2    1                           2n-1                         4n-3
 * Δ=        2                     2n-2  2n                    4n-4   4n-2
 * Δ=        3               2n-3        2n+1              4n-5       .
 * Δ=        .           .               .               .            .
 * Δ=        .       n+2                 .           3n               .
 * Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
 * Δ=2n-2    n                           3n-2                         5n-4
 */
public class ZigZag6{
	public String convert(String s,int numRows){
		int len=s.length();
		if(len==0||numRows<2) return s;

		char[] ret=new char[len];
		int interval=2*numRows-2;   //Cycle period
		int k=0;
		for(int i=0;i<numRows;i++){
			for(int j=i;j<len;j+=interval){
				ret[k++]=s.charAt(j);

				if(i>0&&i<numRows-1){
					int t=j+interval-2*i;
					if(t<len){
						ret[k++]=s.charAt(t);
					}
				}
			}
		}
		return String.valueOf(ret);
	}

	public static void main(String[] args){
		ZigZag6 z=new ZigZag6();
		System.out.println(z.convert("1234567",4));
	}
}
