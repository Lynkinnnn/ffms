package com.wowo.ffms.utils;

@SuppressWarnings("all")
public class PageUtil {


    //获得分页条数组
    public static String getPageNum(Integer totalPages,Integer pn){

        if (totalPages >= 5) {
            if (pn == 0 || pn == 1 || pn == 2) {
                int[] nums = {1, 2, 3, 4, 5};
                //String str = "1,2,3,4,5";
                StringBuffer str = new StringBuffer();
                for(int i = 0; i < nums.length; i++){
                    str.append(nums[i]+",");
                }
                String newStr = str.toString();

                String str3 =newStr.substring(0, str.length() - 1);
                return str3;
            } else if (pn == totalPages - 1 || pn == totalPages - 2 || pn == totalPages -3){
                //int[] nums = {totalPages - 4, totalPages - 3, totalPages - 2, totalPages - 1, totalPages};
                String a = String.valueOf(totalPages - 4);
                String b = String.valueOf(totalPages - 3);
                String c = String.valueOf(totalPages - 2);
                String d = String.valueOf(totalPages - 1);
                String e = String.valueOf(totalPages);
                String str = a+","+b+","+c+","+d+","+e;
                return str;
            }else {
                //int[] nums = {pn-3,pn-2,pn-1,pn,pn+1};
                String a = String.valueOf(pn-1);
                String b = String.valueOf(pn);
                String c = String.valueOf(pn+1);
                String d = String.valueOf(pn+2);
                String e = String.valueOf(pn+3);
                String str = a+","+b+","+c+","+d+","+e;
                return str;
            }

        }else {
            int[] nums = new int[totalPages+1];
            for (int i=totalPages;i>0;i--){
                nums[i] = i;
            }
            StringBuffer str = new StringBuffer();
            for(int i = 1; i < nums.length; i++){
                str.append(nums[i]+",");
            }
            String newStr = str.toString();
            String str3 =newStr.substring(0, str.length() - 1);
            return str3;
        }
    }

}
