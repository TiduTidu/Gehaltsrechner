package com.c3c2;
public class LohnsteuerTabelle {
    public static int[][] getLohnsteuerTabelle() {
        return new int[][] {
                { 5000, 0, 0, 0, 0, 416, 561 },
                { 7500, 0, 0, 0, 0, 696, 841 },
                { 10_000, 0, 0, 0, 0, 977, 1122 },
                { 12_500, 0, 0, 0, 0, 1258, 1403 },
                { 15_000, 190, 0, 0, 190, 1538, 1905 },
                { 17_500, 601, 239, 0, 601, 2395, 2830 },
                { 20_000, 1131, 686, 0, 1131, 3363, 3799 },
                { 22_500, 1646, 1187, 0, 1646, 4239, 4674 },
                { 25_000, 2175, 1702, 0, 2175, 5108, 5472 },
                { 27_500, 2723, 2235, 272, 2723, 5840, 6216 },
                { 30_000, 3288, 2786, 662, 3288, 6602, 6996 },
                { 32_500, 3871, 3355, 1094, 3871, 7400, 7812 },
                { 35_000, 4472, 3942, 1536, 4472, 8232, 8663 },
                { 37_500, 5091, 4547, 2020, 5091, 9097, 9532 },
                { 40_000, 5727, 5170, 2522, 5727, 9966, 10_401 },
                { 42_500, 6382, 5811, 3034, 6382, 10_835, 11_270 },
                { 45_000, 7054, 6470, 3554, 7054, 11_704, 12_139 },
                { 47_500, 7745, 7147, 4084, 7745, 12_573, 13_008 },
                { 50_000, 8453, 7841, 4622, 8453, 13_442, 13_877 },
                { 52_500, 9179, 8554, 5168, 9179, 14_311, 14_746 },
                { 55_000, 9923, 9285, 5724, 9923, 15_180, 15_615 },
                { 57_500, 10_685, 10_034, 6290, 10_685, 16049, 16_484 },
                { 60_000, 11_534, 10_868, 6916, 11_534, 16995, 17_430 },
                { 62_500, 12_426, 11_742, 7566, 12_426, 17963, 18_398 },
                { 65_000, 13_339, 12_639, 8228, 13_339, 18931, 19_366 },
                { 67_500, 14_275, 13_557, 8902, 14_275, 19899, 20_334 },
                { 70_000, 15_223, 14_498, 9586, 15_233, 20867, 21_302 }
        };
    }
}