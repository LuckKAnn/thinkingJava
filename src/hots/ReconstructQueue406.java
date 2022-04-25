package hots;

public class ReconstructQueue406 {

    public int[][] reconstructQueue(int[][] people) {


        int [][]ans = new int[people.length][people[0].length];
        ans[0] = people[0];
        for (int i = 1; i < people.length; i++) {
            int h = people[i][0];
            int cnt = people[i][1];
            int j = 0;
            for (j = 0; j < i; j++) {
                if (ans[j][0]>=people[i][0]){
//                    比他高
                    if (cnt==0){

                    }
                    else cnt--;
                }


            }

        }


        return people;
    }
}
