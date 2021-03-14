class Solution {
    private class StudentClass{
        private Double increaseInProfiByAddding1;
        private int passStud;
        private int totalStud;
        StudentClass(Double profit, int passStud, int totalStud){
            this.increaseInProfiByAddding1 = profit;
            this.passStud = passStud;
            this.totalStud = totalStud;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<StudentClass> pq = new PriorityQueue<StudentClass>((a,b) -> (Double.compare(b.increaseInProfiByAddding1, a.increaseInProfiByAddding1)));

        double totalAverage = 0;
        for(int i=0;i<classes.length;i++){
            totalAverage += classes[i][0]/(double)classes[i][1];
            double increaseInProfiByAddding1 = getIncreaseInProfiByAddding1(classes[i][0], classes[i][1]);
            pq.offer(new StudentClass(increaseInProfiByAddding1, classes[i][0]+1, classes[i][1]+1));
        }

        while(extraStudents-->0){
            StudentClass head = pq.poll();
            totalAverage += head.increaseInProfiByAddding1;
            head.increaseInProfiByAddding1 = getIncreaseInProfiByAddding1(head.passStud, head.totalStud);
            head.passStud++;
            head.totalStud++;
            pq.offer(head);
        }
        return totalAverage/classes.length;
    }

    private Double getIncreaseInProfiByAddding1(int passCount, int totalCount ){
        return (passCount+1)/(double)(totalCount+1) - (passCount)/(double)(totalCount);
    }
}