/*
Name: Exercises
Data source: 1
Created By: Maurício Aniche
Last Updated At: 2021-10-04T16:37:51.558Z
*/
SELECT exercises.id as value, courses.name || '/' || exercises.name as name
FROM exercises
JOIN courses ON courses.id = exercises.course_id;