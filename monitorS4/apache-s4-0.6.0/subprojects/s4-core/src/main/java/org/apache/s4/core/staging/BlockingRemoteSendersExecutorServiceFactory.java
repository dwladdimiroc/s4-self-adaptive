/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.s4.core.staging;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Blocking implementation of the remote senders executor factory. It clones the implementation of the
 * {@link BlockingSenderExecutorServiceFactory} class.
 * <p>
 * This is convenient for sending events through adapters.
 * 
 */
public class BlockingRemoteSendersExecutorServiceFactory extends BlockingSenderExecutorServiceFactory implements
        RemoteSendersExecutorServiceFactory {

    @Inject
    public BlockingRemoteSendersExecutorServiceFactory(@Named("s4.sender.parallelism") int threadPoolSize,
            @Named("s4.sender.workQueueSize") int workQueueSize) {
        super(threadPoolSize, workQueueSize);
    }

}