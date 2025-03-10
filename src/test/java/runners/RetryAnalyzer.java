package runners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);
    private static final int MAX_RETRY_COUNT = 2;
    private int currentRetry = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (currentRetry < MAX_RETRY_COUNT) {
            currentRetry++;
            logger.info("Retrying scenario: '{}' Retry attempt {}/{}",
                    result.getName(), currentRetry, MAX_RETRY_COUNT);
            return true;
        }
        return false;
    }
}