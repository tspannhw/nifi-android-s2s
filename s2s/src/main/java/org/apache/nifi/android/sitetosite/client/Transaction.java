/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.android.sitetosite.client;

import org.apache.nifi.android.sitetosite.packet.DataPacket;

import java.io.IOException;

public interface Transaction {

    /**
     * Sends the dataPacket to NiFi
     *
     * @param dataPacket the dataPacket
     * @throws IOException if there is an error sending it
     */
    void send(DataPacket dataPacket) throws IOException;

    /**
     * Confirms the sent data and verifies the checksum
     *
     * @throws IOException if there is a problem confirming or verifying the checksum
     */
    void confirm() throws IOException;

    /**
     * Completes the transaction
     *
     * @return a transaction result
     * @throws IOException if there is a problem completing the transaction
     */
    TransactionResult complete() throws IOException;

    /**
     * Cancels the transaction
     *
     * @return a transaction result
     * @throws IOException if there is a problem canceling the transaction
     */
    TransactionResult cancel() throws IOException;
}
