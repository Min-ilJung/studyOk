package test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class testArray {

    public static void main(String[] arg){
        ArrayList<String> listA = new ArrayList<String>();
        ArrayList<String> listB = new ArrayList<String>();

        listA.add("테스트뱃지1");
        listA.add("테스트뱃지2");
        listA.add("테스트뱃지3");
        listA.add("테스트뱃지4");
/*
        listB.add("테스트뱃지2");
        listB.add("테스트뱃지4");
        listB.add("테스트뱃지3");
        listB.add("테스트뱃지1");
*/

        listB.add("테스트뱃지2");
        listB.add("테스트뱃지4");
        listB.add("테스트뱃지5");

        //두 배열 비교 방법
        Boolean listCp = listA.containsAll(listB);
        System.out.println("배열이 같은가 : "+ listCp);
        //배열 순서까지 비교
        //Collections.sort(listB);
        //System.out.println("listB : "+ listB);
        listCp = Arrays.equals(listA.toArray(), listB.toArray());
        System.out.println("배열이 같은가 : "+ listCp);

        //추가되어야 하는 리스트
        ArrayList<String> insertList = new ArrayList(listA);
        insertList.removeAll(listB);
        System.out.println("신규추가목록 : "+ insertList);

        //삭제되어야 하는 리스트
        ArrayList<String> deleteList = new ArrayList(listB);;
        deleteList.removeAll(listA);
        System.out.println("삭제목록 : "+ deleteList);

    }
}
