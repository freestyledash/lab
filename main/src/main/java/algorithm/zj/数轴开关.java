package algorithm.zj;

import com.google.common.collect.Lists;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 数轴开关 {


    public static void main(String[] args) {
        StepResult stepResult = new StepResult();
        stepResult.totalCostTime = 0;
        stepResult.restCandidate = Lists.newArrayList(-3, -1, 1, 2, 3);
        stepResult.pos = 0;
        stepResult.rest = 3;

        ArrayList<Integer> results = new ArrayList<>();

        search(stepResult, results);

        int result = Integer.MAX_VALUE;
        for (Integer a : results) {
            result = Math.min(a, result);
        }

        System.out.println(result);
    }


    static class StepResult {

        public int totalCostTime = 0;

        public List<Integer> restCandidate;

        public Integer pos = 0;

        public int rest = 3;

    }


    /**
     * 搜索
     */
    public static StepResult search(StepResult lastResult, final List<Integer> result) {

        if (lastResult.rest == 0) {
            result.add(lastResult.totalCostTime);
            return null;
        }

        Integer leftClosingPos = null;
        Integer rightClosingPos = null;
        boolean findRight = false;

        for (int i = 0; i < lastResult.restCandidate.size(); i++) {
            Integer current = lastResult.restCandidate.get(i);
            if (!findRight && current > lastResult.pos) {
                findRight = true;
                rightClosingPos = current;
            }

            if (current < lastResult.pos) {
                leftClosingPos = current;
            }
        }

        System.out.println("当前位置" + lastResult.pos + " 左边:" + leftClosingPos + "右边 " + rightClosingPos);


        //往左走
        if (leftClosingPos != null) {
            int timeCostTime = lastResult.pos - leftClosingPos;

            ArrayList<Integer> newCandidate = new ArrayList<>();
            for (Integer integer : lastResult.restCandidate) {
                newCandidate.add(integer);
            }
            Iterator<Integer> iterator = newCandidate.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next.equals(leftClosingPos)) {
                    iterator.remove();
                    break;
                }
            }

            StepResult newStepResult = new StepResult();
            newStepResult.totalCostTime = lastResult.totalCostTime + timeCostTime;
            newStepResult.pos = leftClosingPos;
            newStepResult.restCandidate = newCandidate;
            newStepResult.rest = lastResult.rest - 1;

            System.out.println("<-");
            search(newStepResult, result);
        }

        //往右
        if (rightClosingPos != null) {
            int timeCostTime = rightClosingPos - lastResult.pos;

            ArrayList<Integer> newCandidate = new ArrayList<>();
            for (Integer integer : lastResult.restCandidate) {
                newCandidate.add(integer);
            }

            Iterator<Integer> iterator = newCandidate.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next.equals(rightClosingPos)) {
                    iterator.remove();
                    break;
                }
            }

            StepResult newStepResult = new StepResult();
            newStepResult.totalCostTime = lastResult.totalCostTime + timeCostTime;
            newStepResult.pos = rightClosingPos;
            newStepResult.rest = lastResult.rest - 1;
            newStepResult.restCandidate = newCandidate;

            System.out.println("->");
            search(newStepResult, result);
        }


        return null;


    }


}
