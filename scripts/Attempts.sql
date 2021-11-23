/*
Name: Attempts
Data source: 1
Created By: Maurício Aniche
Last Updated At: 2021-11-22T23:44:25.142Z
*/
SELECT attempts, COUNT(*)
FROM (
    SELECT COUNT(*) AS attempts
    FROM submissions
    WHERE submissions.exercise_id::text = '{{ Exercise }}'
    GROUP BY submissions.student_id
) AS foo
GROUP BY attempts;