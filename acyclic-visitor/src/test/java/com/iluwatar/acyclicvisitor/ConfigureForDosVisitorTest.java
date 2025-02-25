/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.acyclicvisitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.org.lidalia.slf4jext.Level.INFO;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * ConfigureForDosVisitor test class
 */
class ConfigureForDosVisitorTest {

  private final TestLogger logger = TestLoggerFactory.getTestLogger(ConfigureForDosVisitor.class);

  @Test
  void testVisitForZoom() {
    var conDos = new ConfigureForDosVisitor();
    var zoom = new Zoom();

    conDos.visit(zoom);

    ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents();
    assertEquals(1, loggingEvents.size());
    for (LoggingEvent loggingEvent : loggingEvents) {
      assertEquals(INFO, loggingEvent.getLevel());
      assertEquals(zoom + " used with Dos configurator.", loggingEvent.getMessage());
    }
  }

  @Test
  void testVisitForHayes() {
    var conDos = new ConfigureForDosVisitor();
    var hayes = new Hayes();

    conDos.visit(hayes);

    ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents();
    assertEquals(1, loggingEvents.size());
    for (LoggingEvent loggingEvent : loggingEvents) {
      assertEquals(INFO, loggingEvent.getLevel());
      assertEquals(hayes + " used with Dos configurator.", loggingEvent.getMessage());
    }
  }

  @BeforeEach
  @AfterEach
  public void clearLoggers() {
    TestLoggerFactory.clear();
  }
}
