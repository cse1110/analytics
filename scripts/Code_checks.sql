/*
Name: Code checks
Data source: 1
Created By: Maurício Aniche
Last Updated At: 2021-11-22T23:47:20.846Z
*/
SELECT code_checks.name, COUNT(*) FILTER (WHERE code_check_submissions.passed) / COUNT(*)::decimal * 100 AS ratio
FROM submissions
JOIN code_check_submissions ON code_check_submissions.submission_id = submissions.id
JOIN code_checks ON code_checks.id = code_check_submissions.code_check_id
WHERE submissions.exercise_id::text = '{{ Exercise }}'
GROUP BY code_checks.id;