package util;

public class PerformanceUtil {
	private static long beforeUsed, afterUsed;
	private static double totalUsed;
	private static long start;
	private static long end;
	private static long totalTime;

	public static void calcPerformance(Predicate predicate, Object... params) {
		beforeTest();
		System.out.println("# Test Result : " + predicate.test(params));
		System.out.println("# Performance Test Result : " + afterTest());
	}


	private static void beforeTest() {
		Runtime.getRuntime().gc();
		beforeUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		start = System.currentTimeMillis();
	}

	private static String afterTest() {
		end = System.currentTimeMillis();
		afterUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		totalUsed = Math.round((afterUsed - beforeUsed)/1024.0/1024.0*100.0)/100.0;
		totalTime = end - start;

		return "totalUsed : " + totalUsed + "(bytes) , totalTime : " + totalTime + "(ms)";
	}
}
