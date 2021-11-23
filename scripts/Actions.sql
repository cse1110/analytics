/*
Name: Actions
Data source: 1
Created By: Maurício Aniche
Last Updated At: 2021-11-22T23:50:48.055Z
*/
SELECT submissions.action, COUNT(*)
FROM submissions
WHERE submissions.exercise_id::text = '{{ Exercise }}'
GROUP BY submissions.action;