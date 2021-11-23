/*
Name: Grades
Data source: 1
Created By: Maurício Aniche
Last Updated At: 2021-11-22T23:45:12.652Z
*/
SELECT grade, COUNT(*)
FROM (
    SELECT MAX(submissions.grade) as grade
    FROM submissions
    WHERE submissions.exercise_id::text = '{{ Exercise }}'
    GROUP BY submissions.student_id
) AS foo
GROUP BY grade;