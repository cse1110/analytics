/*
Name: Line coverages
Data source: 1
Created By: Yoon Hwan Jeong
Last Updated At: 2021-11-22T23:48:54.219Z
*/
SELECT submissions.line_coverage_covered, COUNT(*)
FROM submissions
WHERE submissions.exercise_id = '{{ Exercise }}'
GROUP BY submissions.line_coverage_covered;