/*
Name: Meta tests
Data source: 1
Created By: Yoon Hwan Jeong
Last Updated At: 2021-11-22T23:47:58.230Z
*/
SELECT meta_tests.name, COUNT(*) FILTER (WHERE meta_test_submissions.passed) / COUNT(*)::decimal * 100 as ratio
FROM submissions
JOIN meta_test_submissions ON meta_test_submissions.submission_id = submissions.id
JOIN meta_tests ON meta_tests.id = meta_test_submissions.meta_test_id
WHERE submissions.exercise_id::text = '{{ Exercise }}'
GROUP BY meta_tests.id;