package com.pluralsight.aspect;

import com.pluralsight.AppConfig;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImp;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TracingAspectTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    CustomerService customerServiceImp;

    @Test
    public void aspectIsCalled() {
        // arrange
        Logger logger = Logger.getLogger(TracingAspect.class);

        final TestAppender appender = new TestAppender();
        logger.addAppender(appender);

        // act
        customerServiceImp.findAll();
        // assert
        final List<LoggingEvent> log = appender.getLog();
        final LoggingEvent firstLogEntry = log.get(0);
        Assert.assertEquals(log.size(), 2);

    }

    class TestAppender extends AppenderSkeleton {
        private final List<LoggingEvent> log = new ArrayList<LoggingEvent>();

        @Override
        public boolean requiresLayout() {
            return false;
        }

        @Override
        protected void append(final LoggingEvent loggingEvent) {
            log.add(loggingEvent);
        }

        @Override
        public void close() {
        }

        public List<LoggingEvent> getLog() {
            return new ArrayList<LoggingEvent>(log);
        }
    }
}
