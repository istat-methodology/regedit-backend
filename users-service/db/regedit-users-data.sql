INSERT INTO `regedit_users`.`roles` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `regedit_users`.`roles` VALUES (2, 'ROLE_SUPERVISOR');
INSERT INTO `regedit_users`.`roles` VALUES (3, 'ROLE_REVIEWER');


INSERT INTO `regedit_users`.`users` VALUES (1, 'admin@is2.it', 'Administrator', 'Workbench', '$2a$10$VB7y/I.oD16QBVaExgH1K.VEuBUKRyXcCUVweUGhs1vDl0waTQPmC', 1);
INSERT INTO `regedit_users`.`users` VALUES (2, 'user@is2.it', 'User', 'Workbench', '$2a$10$yK1pW21E8nlZd/YcOt6uB.n8l36a33RP3/hehbWFAcBsFJhVKlZ82', 3);
INSERT INTO `regedit_users`.`users` VALUES (3, 'fra@fra.it', 'Francesco Amato', 'fra', '$2a$10$DIcyvIFwhDkEOT9nBugTleDM73OkZffZUdfmvjMCEXdJr3PZP8Kxm', 2);
