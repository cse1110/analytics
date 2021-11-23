/*
Name: Mutants
Data source: 1
Created By: Yoon Hwan Jeong
Last Updated At: 2021-11-22T23:50:03.706Z
*/
SELECT submissions.mutants_killed, COUNT(*)
FROM submissions
WHERE submissions.exercise_id::text = '{{ Exercise }}'
GROUP BY submissions.mutants_killed;