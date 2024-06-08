DROP TABLE IF EXISTS `portal`.additions;

CREATE TABLE `portal`.additions (
	id INT PRIMARY KEY auto_increment,
  buildId INT NULL,
	platformId INT NULL,
	databaseId INT NULL,
  frameworkId INT NULL,
  langId INT NULL,
  loggingId INT NULL,
  programmingId INT DEFAULT 0,
  rulesId INT NULL,
  testId INT NULL,
  securityId INT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE INDEX IDX_BUILD ON `portal`.additions(buildId);
CREATE INDEX IDX_PLATFORM ON `portal`.additions(platformId);
CREATE INDEX IDX_DATABASE ON `portal`.additions(databaseId);
CREATE INDEX IDX_FRAMEWORK ON `portal`.additions(frameworkId);
CREATE INDEX IDX_LANG ON `portal`.additions(langId);
CREATE INDEX IDX_LOG ON `portal`.additions(loggingId);
CREATE INDEX IDX_RULE ON `portal`.additions(rulesId);
CREATE INDEX IDX_TEST ON `portal`.additions(testId);
CREATE INDEX IDX_SECURITY ON `portal`.additions(securityId);
