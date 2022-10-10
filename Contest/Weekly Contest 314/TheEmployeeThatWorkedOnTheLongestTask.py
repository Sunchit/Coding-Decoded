# https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task
# author : @Jiganesh

from typing import List
class Solution:
    
    # TC: O(N)
    # SC: O(1)
    def hardestWorker(self, n: int, logs: List[List[int]]) -> int:
        start = 0
        max_task_time = float("-inf")
        hard_working_employee_id = 0 

        for log in logs:
            
            emp_id , end = log
            task_time = (end-start)

            if task_time > max_task_time:
                max_task_time = task_time
                hard_working_employee_id = emp_id
            
            elif task_time == max_task_time:
                hard_working_employee_id = min(hard_working_employee_id, emp_id)
            
            start = end

        return hard_working_employee_id
