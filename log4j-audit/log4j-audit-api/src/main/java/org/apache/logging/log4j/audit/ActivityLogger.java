/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.audit;

import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.StructuredDataMessage;
import org.apache.logging.log4j.spi.ExtendedLogger;

/**
 *
 */
public class ActivityLogger extends AbstractEventLogger {
    private static final String NAME = "ActivityLogger";

    private static final String FQCN = ActivityLogger.class.getName();
    private static final Marker EVENT_MARKER =
            MarkerManager.getMarker("Activity").addParents(EventLogger.EVENT_MARKER);
    private static final ExtendedLogger LOGGER = LogManager.getContext(false).getLogger(NAME);

    public ActivityLogger() {
        super();
    }

    public ActivityLogger(int maxLength) {
        super(maxLength);
    }

    @Override
    protected void logEvent(StructuredDataMessage message) {
        LOGGER.logIfEnabled(FQCN, Level.OFF, EVENT_MARKER, message, null);
    }
}
