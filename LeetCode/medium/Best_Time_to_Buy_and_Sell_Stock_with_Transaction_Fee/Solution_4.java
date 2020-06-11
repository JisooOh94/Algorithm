package medium.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

public class Solution_4 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
//        int fee = 2;
//        int[] prices = new int[]{1619, 1810, 2047, 1362, 2387, 648, 2858, 3008, 1212, 2489, 639, 2589, 3107, 1927, 499, 411, 3830, 3077, 4165, 4133, 2359, 2749, 713, 1156, 4856, 3484, 2602, 231, 4315, 3633, 2829, 4704, 24, 2659, 4247, 495, 1532, 1943, 4664, 1194, 1446, 4232, 864, 4545, 1111, 3875, 3250, 2322, 3899, 2301, 1736, 1308, 479, 1574, 1475, 3335, 4975, 1344, 2870, 3354, 107, 4488, 327, 3685, 181, 4406, 2220, 2369, 2624, 2522, 2718, 453, 3672, 2931, 20, 1247, 2533, 1139, 1998, 2256, 273, 4176, 124, 709, 1855, 2611, 1631, 2196, 3929, 1385, 4143, 2739, 3597, 509, 1243, 3559, 3705, 3955, 1946, 3592, 713, 2363, 3869, 3253, 271, 2928, 1621, 3231, 2007, 1450, 2791, 3373, 1594, 1521, 3850, 1842, 2496, 2037, 1627, 3694, 1605, 2517, 1729, 2543, 4071, 4032, 80, 769, 455, 3525, 3921, 2584, 397, 4103, 590, 1711, 1457, 1801, 1803, 3716, 4885, 4936, 4658, 3189, 2722, 3724, 3702, 266, 2637, 1331, 2285, 2721, 2201, 2587, 2038, 4986, 3109, 4284, 785, 2538, 3463, 20, 3643, 1735, 3431, 4956, 4513, 1409, 2080, 2456, 4231, 2354, 639, 4288, 1109, 524, 3668, 3867, 3658, 2868, 711, 772, 3660, 2121, 4847, 3894, 3792, 2309, 976, 2408, 3699, 2963, 1597, 2703, 4594, 1360, 4624, 289, 3389, 89, 2089, 4964, 934, 322, 4459, 3917, 2770, 2314, 2671, 3067, 3027, 2023, 2878, 4104, 4213, 2694, 2922, 3389, 4808, 3320, 2835, 1813, 493, 854, 1511, 3467, 3836, 3096, 634, 1280, 2027, 3997, 1742, 1030, 1304, 2445, 960, 343, 331, 282, 2104, 3241, 529, 2381, 1642, 1991, 3710, 1179, 554, 2880, 3532, 2284, 3617, 4407, 3998, 1100, 2400, 3804, 4922, 1328, 3718, 1478, 4709, 3739, 751, 3512, 131, 3701, 1636, 4958, 815, 2406, 2737, 743, 951, 4177, 4101, 1441, 1525, 3168, 4950, 3737, 758, 4975, 546, 3857, 4173, 2355, 2543, 490, 4360, 364, 4012, 3406, 2272, 3538, 3617, 261, 3456, 2652, 834, 4250, 1896, 2433, 3769, 4690, 3568, 4779, 4674, 669, 4589, 4186, 2655, 2726, 2264, 1005, 4096, 1295, 2029, 1704, 2606, 3178, 980, 3718, 791, 4201, 761, 177, 3264, 279, 1601, 4062, 4543, 1683, 1666, 635, 4560, 2057, 263, 4866, 2902, 1331, 2396, 3550, 2037, 555, 4971, 2146, 3169, 3370, 1148, 2144, 1792, 1938, 4085, 2585, 3947, 2479, 4345, 2375, 3232, 1538, 3031, 1101, 3842, 2507, 392, 188, 4971, 912, 3799, 2841, 777, 4485, 4889, 995, 263, 4554, 3326, 1829, 2829, 4081, 3976, 1885, 3697, 4479, 2667, 1764, 1330, 3113, 1388, 3085, 4915, 2451, 3356, 53, 4808, 175, 4455, 1379, 4621, 1495, 3966, 4966, 1495, 1998, 3005, 2893, 1250, 3946, 1650, 2707, 3474, 4286, 1810, 1866, 946, 1400, 4089, 459, 328, 4248, 2828, 3781, 4646, 3754, 3488, 4149, 275, 2484, 4815, 3826, 3076, 4956, 1626, 2570, 3337, 1721, 4352, 2148, 4852, 2146, 1844, 3995, 2523, 2556, 3474, 4648, 2020, 4473, 3068, 4256, 4086, 2876, 1996, 4146, 2171, 180, 4186, 3256, 1315, 4592, 351, 4095, 457, 4514, 4175, 1830, 4724, 3271, 3777, 3985, 3458, 2943, 1583, 3210, 2258, 989, 3303, 2730, 4898, 4437, 1295, 3447, 2718, 32, 2356, 134, 205, 1878, 776, 174, 1333, 576, 4299, 2043, 429, 612, 3471, 2546, 1067, 4107, 3331, 1508, 3851, 3834, 1396, 1874, 4968, 435, 1947, 4131, 4923, 3354, 460, 689, 2767, 1184, 3625, 2622, 3567, 3928, 2664, 2835, 4363, 4733, 2556, 1372, 4371, 2049, 1820, 4722, 2496, 3854, 3582, 3338, 2001, 2639, 1828, 1934, 2609, 363, 4187, 485, 2798, 44, 145, 4871, 3529, 1683, 341, 3607, 2098, 4844, 4518, 4431, 889, 1910, 4440, 2297, 2963, 1084, 3204, 4372, 3959, 3516, 2242, 3540, 2430, 125, 3096, 4928, 1807, 4331, 37, 2867, 2952, 284, 2658, 2817, 2248, 1616, 2492, 4954, 3330, 1153, 2273, 190, 2900, 4129, 1906, 4933, 4008, 4093, 4373, 15, 789, 4670, 3388, 782, 2243, 611, 1115, 3798, 2281, 1721, 173, 298, 3789, 1496, 872, 698, 1355, 1980, 2538, 3366, 1685, 76, 3190, 133, 2853, 2426, 3077, 1993, 4138, 4915, 845, 2192, 612, 2234, 4751, 1023, 4255, 1513, 2753, 1002, 3796, 415, 2374, 1340, 1595, 1294, 2122, 1416, 4147, 2247, 2557, 4063, 975, 2318, 1743, 3298, 4753, 910, 2059, 948, 2249, 842, 4927, 3963, 1894, 2010, 789, 2499, 3368, 1143, 241, 2118, 2938, 662, 839, 2206, 4683, 1190, 588, 3072, 1284, 2790, 4041, 1194, 884, 1364, 2635, 3285, 313, 2143, 3366, 1230, 4801, 900, 4828, 3274, 2912, 4541, 1606, 3924, 3238, 1262, 491, 2797, 4883, 53, 3110, 4985, 4104, 4228, 3697, 1730, 2191, 3819, 1786, 2351, 4080, 589, 2504, 4889, 2311, 828, 3367, 649, 2519, 3243, 3721, 1954, 4975, 3294, 4780, 4086, 1290, 338, 1552, 586, 4546, 76, 3932, 1314, 2106, 2344, 1266, 4283, 1598, 2090, 4697, 2465, 3200, 2503, 62, 2297, 57, 3794, 1671, 3113, 1670, 4157, 1189, 2117, 3074, 3669, 2603, 3001, 3289, 3895, 4523, 4684, 3162, 3151, 2127, 1004, 2784, 168, 3925, 2261, 912, 1450, 3889, 4345, 1817, 2428, 2918, 3755, 1892, 2083, 4540, 2461, 4837, 2807, 2747, 3970, 180, 1687, 2737, 4131, 2372, 1502, 3753, 160, 3271, 4444, 4239, 4433, 3673, 670, 2781, 1941, 1347, 1928, 1544, 2040, 1619, 393, 2567, 3461, 4298, 2575, 4417, 4247, 2143, 431, 3302, 982, 2478, 3284, 3431, 4114, 2377, 806, 2925, 3026, 1269, 4991, 3399, 2823, 2148, 1887, 2084, 2967, 523, 1835, 3237, 1282, 2152, 386, 1039, 2363, 2692, 973, 251, 2970, 2503, 1227, 3739, 1803, 2839, 482, 722, 2623, 1210, 820, 3310, 3789, 1235, 2653, 28, 3556, 2739, 4171, 1943, 96, 4325, 3050, 4072, 2653, 1862, 4194, 4042, 4147, 4655, 491, 2527, 440, 3142, 1509, 770, 270, 1069, 4251, 3720, 3396, 3558, 4513, 131, 1050, 1010, 2516, 2776, 4222, 1935, 4114, 2675, 986, 2710, 320, 4222, 588, 3124, 2856, 1074, 4791, 3275, 1836, 2443, 3167, 2408, 2628, 2661, 641, 4018, 2374, 4538, 1870, 3316, 3610, 876, 3271, 1972, 1184, 1112, 3347, 4383, 568, 2945, 1051, 4175, 2989, 2084, 390, 2536, 603, 61, 996, 340, 1541, 2811, 91, 4350, 4802, 4019, 1146, 538, 691, 1964, 4854, 2146, 2368, 4669, 2482, 3849, 1356, 2233, 3580, 4541, 2602, 570, 680, 4174, 2272, 3573, 2643, 3361, 2417, 3399, 3910, 1745, 4132, 102, 4027, 9, 2166, 929, 3373, 1250, 2881, 4661, 1286, 163, 2303, 950, 1846, 3361, 3774, 2073, 1983, 2660, 4506, 3935, 2771, 3489, 408, 3537, 4606};
//        int fee = 4490;
        int[] prices = new int[]{4,5,2,4,3,3,1,2,5,4};
        int fee = 1;
        PerformanceUtil.calcPerformance(new Solution_4(), (Object) prices, fee);
    }

    @Override
    public Integer test(Object... params) {
        return maxProfit((int[]) params[0], (int) params[1]);
    }

    private int recursion(int startIdx, int fee, int[] prices, int[] maxProfixArr) {
        if (prices.length - 1 <= startIdx) return 0;

        if (maxProfixArr[startIdx] != 0) return maxProfixArr[startIdx];

        int maxProfit = 0;

        for (int buyIdx = startIdx; buyIdx < prices.length - 1; buyIdx++) {
            int buyPrice = prices[buyIdx];
            for (int sellIdx = buyIdx + 1; sellIdx < prices.length; sellIdx++) {
                int sellPrice = prices[sellIdx];
                if (buyPrice + fee < sellPrice) {
                    int profit = sellPrice - buyPrice - fee + recursion(sellIdx + 1, fee, prices, maxProfixArr);
                    if (maxProfit < profit) maxProfit = profit;
                }
            }
        }

        maxProfixArr[startIdx] = maxProfit;
        return maxProfit;
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;

        int[] maxProfitArr = new int[prices.length];

        int result = recursion(0, fee, prices, maxProfitArr);
        return result;
    }
}
