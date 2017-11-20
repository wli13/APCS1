public class StatsDriver {

    public static int mean(int a, int b){
	int retVal = ( ( a + b ) / 2 );

	return retVal;
    }
    
    //public static double mean(double a, double b);
    //public static int max(int a, int b);
    //public static double max(double a, double b);
    
    public static int geoMean(int a, int b){
	int retVal = (int) Math.sqrt( a * b );
	
	return retVal;
    }
    
    public static double geoMean(double a, double b){
	double retVal = Math.sqrt( a * b );

	return retVal;
    }
    
    public static void main(String[] args){

	System.out.println("Testing mean(0,10);");
	System.out.println(mean(0,10));
	mean(1,2);
	System.out.println(mean(1,3));
	geoMean(1,9);
	System.out.println(geoMean(1,9));

	geoMean(1.0,9.0);
	System.out.println(geoMean(1.0,9.0));
	geoMean(1,2.25);
	System.out.println(geoMean(1,2.25));
			   
    }
}
